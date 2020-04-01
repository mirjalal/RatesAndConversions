package aze.talmir.task.ratesconversions.ui.main

import androidx.lifecycle.ViewModel
import aze.talmir.task.ratesconversions.data.IRatesConversionsRepository
import java.math.BigDecimal

/**
 * Classic ViewModel class. Helps UI (fields) to communicate with
 * repository layer.
 */
class RatesConversionsViewModel(
    private val ratesConversionsRepository: IRatesConversionsRepository
) : ViewModel() {

    suspend fun getRatesAndConversions(baseCurrency: String, coefficient: BigDecimal) =
        ratesConversionsRepository.getRates(baseCurrency, coefficient)
}
