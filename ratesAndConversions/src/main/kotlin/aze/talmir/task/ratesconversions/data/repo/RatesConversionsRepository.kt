package aze.talmir.task.ratesconversions.data.repo

import aze.talmir.task.ratesconversions.data.IRatesConversionsDataSource
import aze.talmir.task.ratesconversions.data.IRatesConversionsRepository
import aze.talmir.task.ratesconversions.helpers.Result
import aze.talmir.task.ratesconversions.helpers.asCurrencyData
// import aze.talmir.task.ratesconversions.helpers.wrapEspressoIdlingResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.math.BigDecimal

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

    override suspend fun getRates(base: String, coefficient: BigDecimal) =
        withContext(ioDispatcher) {
            when (val callResult = ratesConversionsRemoteDataSource.getRates(base)) {
                is Result.Success -> return@withContext Result.Success(
                    callResult.data.asCurrencyData(
                        coefficient
                    )
                )
                is Result.Error -> return@withContext Result.Error(callResult.msg)
            }
        }
}
