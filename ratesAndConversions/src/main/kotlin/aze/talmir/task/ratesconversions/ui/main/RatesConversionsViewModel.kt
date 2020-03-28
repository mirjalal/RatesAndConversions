package aze.talmir.task.ratesconversions.ui.main

import androidx.lifecycle.ViewModel
import aze.talmir.task.ratesconversions.data.remotesource.IRatesConversionsRepository

/**
 * Classic ViewModel class. Helps UI (fields) to communicate with
 * repository layer.
 */
class RatesConversionsViewModel(
    private val ratesConversionsRepository: IRatesConversionsRepository
) : ViewModel() {

    suspend fun getRatesAndConversions(baseCurrency: String, coefficient: Double) =
        ratesConversionsRepository.getRates(baseCurrency, coefficient)
}
