package aze.talmir.task.ratesconversions.data.remotesource

import aze.talmir.task.ratesconversions.data.Result
import aze.talmir.task.ratesconversions.data.model.CurrencyData
import aze.talmir.task.ratesconversions.data.remotesource.network.RatesConversionsApiModel

interface IRatesConversionsRepository {
    suspend fun getRates(base: String, coefficient: Double): Result<Sequence<CurrencyData>>
}

interface IRatesConversionsDataSource {
    suspend fun getRates(base: String): Result<RatesConversionsApiModel>
}
