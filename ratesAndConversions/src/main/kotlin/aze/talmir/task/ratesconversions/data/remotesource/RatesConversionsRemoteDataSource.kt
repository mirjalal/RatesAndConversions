package aze.talmir.task.ratesconversions.data.remotesource

import aze.talmir.task.ratesconversions.data.Result
import aze.talmir.task.ratesconversions.data.remotesource.network.RateConversionsRemoteDataRetrieverApi.rateConversionsDataRetrieverApiService
import aze.talmir.task.ratesconversions.helpers.asCurrencyData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RatesConversionsRemoteDataSource(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IRatesConversionsDataSource {

    override suspend fun getRates(base: String, coefficient: Double) =
        withContext(ioDispatcher) {
            return@withContext try {
                val networkRequest =
                    rateConversionsDataRetrieverApiService.getRateConversions(base)
                val rates = networkRequest.body()

                if (networkRequest.isSuccessful && rates != null)
                    Result.Success(rates.asCurrencyData(coefficient))
                else
                    Result.Error("Network request failed.")
            } catch (e: Exception) {
                Result.Error("Oops. Something went wrong. ${e.message}")
            }
        }
}
