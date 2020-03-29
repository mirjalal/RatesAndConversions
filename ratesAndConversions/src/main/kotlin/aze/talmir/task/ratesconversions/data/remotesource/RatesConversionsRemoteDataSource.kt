package aze.talmir.task.ratesconversions.data.remotesource

import aze.talmir.task.ratesconversions.data.IRatesConversionsDataSource
import aze.talmir.task.ratesconversions.data.remotesource.network.RateConversionsRemoteDataRetrieverApi.rateConversionsDataRetrieverApiService
import aze.talmir.task.ratesconversions.helpers.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Concrete implementation to load rates from the data sources.
 *
 * Regarding to the technical doc, this repository only uses the
 * remote data source. Of course, remote is the source of truth. :)
 */
class RatesConversionsRemoteDataSource(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IRatesConversionsDataSource {

    override suspend fun getRates(base: String) =
        withContext(ioDispatcher) {
            return@withContext try {
                // make network request
                val networkRequest =
                    rateConversionsDataRetrieverApiService.getRateConversions(base)

                // get response
                val rates = networkRequest.body()

                if (networkRequest.isSuccessful && rates != null)
                    Result.Success(rates) // return result
                else
                    Result.Error("Network request failed.") // network call failed
            } catch (e: Exception) {
                Result.Error("Oops. Something went wrong.") // some other error occurred
            }
        }
}
