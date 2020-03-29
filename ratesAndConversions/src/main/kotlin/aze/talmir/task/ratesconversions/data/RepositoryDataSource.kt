package aze.talmir.task.ratesconversions.data

import aze.talmir.task.ratesconversions.data.model.CurrencyData
import aze.talmir.task.ratesconversions.data.remotesource.network.RatesConversionsApiModel
import aze.talmir.task.ratesconversions.helpers.Result

interface IRatesConversionsRepository {
    suspend fun getRates(base: String, coefficient: Double): Result<Sequence<CurrencyData>>
}

interface IRatesConversionsDataSource {
    suspend fun getRates(base: String): Result<RatesConversionsApiModel>
}
