package aze.talmir.task.ratesconversions.data

import aze.talmir.task.ratesconversions.helpers.Result
import aze.talmir.task.ratesconversions.data.model.CurrencyData
import aze.talmir.task.ratesconversions.data.remotesource.network.RatesConversionsApiModel

interface IRatesConversionsRepository {
    suspend fun getRates(base: String, coefficient: Double): Result<Sequence<CurrencyData>>
}

interface IRatesConversionsDataSource {
    suspend fun getRates(base: String): Result<RatesConversionsApiModel>
}
