package aze.talmir.task.ratesconversions.data.remotesource

import aze.talmir.task.ratesconversions.data.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import aze.talmir.task.ratesconversions.helpers.asCurrencyData

/**
 * Repository layer of the application.
 *
 * [getRates] function consumes endpoint API service, grabs data
 * from it, converts it to the proper format by calling [asCurrencyData]
 * extension function and returns converted value back to the our
 * ViewModel.
 */
class RatesConversionsRepository(
    private val ratesConversionsRemoteDataSource: IRatesConversionsDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IRatesConversionsRepository {

    override suspend fun getRates(base: String, coefficient: Double) =
        withContext(ioDispatcher) {
            when (val callResult = ratesConversionsRemoteDataSource.getRates(base)) {
                is Result.Success -> return@withContext Result.Success(
                    callResult.data.asCurrencyData(
                        coefficient
                    )
                )
                is Result.Error -> return@withContext callResult
            }
        }
}
