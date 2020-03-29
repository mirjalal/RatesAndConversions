package aze.talmir.task.ratesconversions.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import aze.talmir.task.ratesconversions.R
import aze.talmir.task.ratesconversions.helpers.Result
import aze.talmir.task.ratesconversions.data.model.CurrencyData
import aze.talmir.task.ratesconversions.databinding.RatesConversionsFragmentBinding
import aze.talmir.task.ratesconversions.helpers.setDivider
import aze.talmir.task.ratesconversions.ui.main.adapter.CurrencyDataItemClickEvent
import aze.talmir.task.ratesconversions.ui.main.adapter.RatesConversionsDataAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

@ObsoleteCoroutinesApi
class RatesConversionsFragment : Fragment() {

    companion object {
        private const val FREQUENCY = 1_000L // a second
        private const val INITIAL_DELAY = 0L

        private const val VISIBLE = View.VISIBLE
        private const val GONE = View.GONE
    }

    private lateinit var binding: RatesConversionsFragmentBinding
    private val viewModel: RatesConversionsViewModel by viewModel()

    private val ratesConversionsData = MutableLiveData<Result<Sequence<CurrencyData>>>()
    private var baseCurrency = "EUR"
    private var coefficient = 1.0
        set(value) {
            field = if (value > 0.0) value
            else 1.0
        }

    private var tickerChannel: ReceiveChannel<Unit>? = null

    init {
        startObservability()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RatesConversionsFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner

        // first thing first, show loading_data animation immediately
        manageUiStates(GONE, VISIBLE, GONE)

        return binding.root
    }

    @ExperimentalCoroutinesApi
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val currencyDataItemClick = CurrencyDataItemClickEvent {
            baseCurrency = it.code
            coefficient = it.rate
        }

        val focusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                stopObservability()
            else {
                stopObservability()
                startObservability(true)
            }
        }
        val coefficientChangeListener = object : TextWatcher {
            var c = 4

            override fun afterTextChanged(s: Editable?) {
                if (c == 1) {
                    stopObservability()
                    coefficient = s.toString().toDoubleOrNull() ?: 1.0
                    startObservability(true)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                c = count
            }
        }

        val adapter = RatesConversionsDataAdapter(
            currencyDataItemClick, coefficientChangeListener, focusChangeListener
        )
        binding.ratesConversionsList.run {
            setDivider(R.drawable.recycler_view_divider)
            itemAnimator = null
            setAdapter(adapter)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    // I know... this is not correct way & this is not
                    // my best solution for the problem, but... till now
                    // could not be able to find working solution for it.
                    // I have also tried the option
                    // android:descendantFocusability="blocksDescendants"
                    // and too many others. But problem was still there...
                    // I am so sorry :(
                    if (newState == RecyclerView.SCROLL_STATE_IDLE)
                        if (tickerChannel?.isClosedForReceive == true)
                            startObservability(true)
                    if (newState == RecyclerView.SCROLL_STATE_DRAGGING)
                        if (tickerChannel?.isClosedForReceive == false)
                            tickerChannel?.cancel()
                }
            })
        }

        ratesConversionsData.observe(viewLifecycleOwner, Observer { result ->
            manageUiStates(GONE, VISIBLE, GONE)

            when (result) {
                is Result.Success -> {
                    adapter.submitList(result.data.toList())
                    manageUiStates(GONE, GONE, VISIBLE)
                }
//                is Result.Error -> println("ERROR: ${result.msg}")
                else -> manageUiStates(VISIBLE, GONE, GONE)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()

        // don't forget to stop the timer :D
        stopObservability()
    }

    /**
     * Setups and starts making network calls. [isImmediate]
     * flag determines if this function should be invoked
     * in fragment lifecycle or not.
     */
    private fun startObservability(isImmediate: Boolean = false) {
        suspend fun setupTicker() {
            tickerChannel = ticker(FREQUENCY, INITIAL_DELAY)
            for (event in tickerChannel!!)
                ratesConversionsData.value =
                    viewModel.getRatesAndConversions(baseCurrency, coefficient)
        }

        if (!isImmediate) lifecycleScope.launchWhenCreated { setupTicker() }
        else lifecycleScope.launch { setupTicker() }
    }

    /**
     * Stops making network request. This will give chance
     * to user to enter coefficient value.
     */
    private fun stopObservability() {
        tickerChannel?.cancel()
        tickerChannel = null
    }

    private fun manageUiStates(errorState: Int, loadingState: Int, mainState: Int) =
        with(binding) {
            errorScreenVisible = errorState
            loadingScreenVisible = loadingState
            mainScreenVisibility = mainState
        }
}
