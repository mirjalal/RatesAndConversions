package aze.talmir.task.ratesconversions.ui.main.adapter

import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import aze.talmir.task.ratesconversions.data.model.CurrencyData
import aze.talmir.task.ratesconversions.databinding.CurrencyDataItemBinding

/**
 * A [RecyclerView] adapter file that implements
 * [ListAdapter] class.
 *
 * @author mirjalal
 * @since 3/27/20
 * https://github.com/mirjalal/android-studio-templates/blob/master/file_templates/recyclerView_with_ListAdapter.vtl
 */
class RatesConversionsDataAdapter(
    private val clickListener: CurrencyDataItemClickEvent,
    private val textChangeListener: TextWatcher,
    private val focusChangeListener: View.OnFocusChangeListener
) :
    ListAdapter<CurrencyData, RatesConversionsDataAdapter.CurrencyDataViewHolder>(DifferChecker) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CurrencyDataViewHolder.from(parent)

    override fun onBindViewHolder(holder: CurrencyDataViewHolder, position: Int) =
        holder.bind(getItem(position), clickListener, textChangeListener, focusChangeListener)

    class CurrencyDataViewHolder private constructor(private val binding: CurrencyDataItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: CurrencyData,
            clickListener: CurrencyDataItemClickEvent,
            textChangeListener: TextWatcher,
            focusChangeListener: View.OnFocusChangeListener
        ) {
            // set binding variables
            binding.currencyData = item
            binding.itemClickListener = clickListener

            if (item.isBase) {
                binding.currencyAmountEditText.run {
                    isClickable = true
                    isFocusable = true
                    isFocusableInTouchMode = true
                    onFocusChangeListener = focusChangeListener
                    addTextChangedListener(textChangeListener)
                    setOnEditorActionListener { v, _, _ ->
                        v.clearFocus()
                        false
                    }
                }
            } else {
                binding.currencyAmountEditText.run {
                    isClickable = false
                    isFocusable = false
                    isFocusableInTouchMode = false
                    removeTextChangedListener(textChangeListener)
                }
            }

            /**
             * causes the properties updates to execute immediately.
             * since I'm calling [bind] from [onBindViewHolder]
             * having the bindings execute immediately. as a practice
             * can prevent the recycler view from having to perform
             * extra calculations when it figures out how to display
             * the list.
             */
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CurrencyDataViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CurrencyDataItemBinding.inflate(layoutInflater, parent, false)

                return CurrencyDataViewHolder(binding)
            }
        }
    }

    /**
     * Callback for calculating the diff between two non-null items in a list.
     *
     * Used by [ListAdapter] to calculate the minimum number of changes between
     * and old list and a new list that's been passed to [submitList].
     */
    companion object DifferChecker : DiffUtil.ItemCallback<CurrencyData>() {
        // We should use referential equality operator - triple equal sign (===) - which returns
        // true if the object references are the same
        override fun areItemsTheSame(oldItem: CurrencyData, newItem: CurrencyData) =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: CurrencyData, newItem: CurrencyData) =
            oldItem.id == newItem.id
    }
}
