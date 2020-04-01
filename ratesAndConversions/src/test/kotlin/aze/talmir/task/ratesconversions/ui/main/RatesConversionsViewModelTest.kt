package aze.talmir.task.ratesconversions.ui.main

import aze.talmir.task.ratesconversions.MainCoroutineRule
import aze.talmir.task.ratesconversions.R
import aze.talmir.task.ratesconversions.data.FakeRateConversionRepository
import aze.talmir.task.ratesconversions.data.model.CurrencyData
import aze.talmir.task.ratesconversions.helpers.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RatesConversionsViewModelTest {

    /**
     * When we use [runBlockingTest] ext function every time for each test,
     * it will create a new [TestCoroutineScope] every time. This could be
     * optimized by somehow. To do that, we can use custom JUnit rules as
     * I did here.
     *
     * [MainCoroutineRule] creates a coroutine dispatcher and then it swaps
     * out Dispatcher.Main for that test coverage in dispatcher. Additionally,
     * it will make us sure that we use  a single test coroutine dispatcher
     * instead of multiple test coroutine dispatchers.
     *
     * Cheers ^_^
     */
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var ratesConversionsRepository: FakeRateConversionRepository

    // subject under test
    private lateinit var rateConversionsViewModel: RatesConversionsViewModel

    private val eurCurrencyData =
        CurrencyData(1, "EUR", "Euro", 41.26.toBigDecimal(), R.drawable.eur, true)
    private val gbpCurrencyData =
        CurrencyData(2, "GBP", "Pound sterling", 41.26.toBigDecimal(), R.drawable.gbp, false)
    private val usdCurrencyData =
        CurrencyData(3, "USD", "United States Dollar", 41.26.toBigDecimal(), R.drawable.usd, false)
    private val ilsCurrencyData =
        CurrencyData(4, "ILS", "Israeli New Shekel", 41.26.toBigDecimal(), R.drawable.ils, false)

    @Before
    fun setupViewModel() {
        ratesConversionsRepository = FakeRateConversionRepository()
        ratesConversionsRepository.addCurrencyData(
            eurCurrencyData, gbpCurrencyData, usdCurrencyData, ilsCurrencyData
        )

        rateConversionsViewModel = RatesConversionsViewModel(ratesConversionsRepository)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getRatesAndConversions_returnsNonNullValue() = mainCoroutineRule.runBlockingTest {
        val value = rateConversionsViewModel.getRatesAndConversions("EUR", 1.2.toBigDecimal())
        assertThat(value, not(nullValue()))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getRatesAndConversions_returnsCorrectValue() = mainCoroutineRule.runBlockingTest {
        val value =
            rateConversionsViewModel.getRatesAndConversions("EUR", 1.2.toBigDecimal()) as Result.Success
        assertThat(
            value.data.toList(),
            IsEqual(
                listOf(eurCurrencyData, gbpCurrencyData, usdCurrencyData, ilsCurrencyData)
            )
        )
    }
}
