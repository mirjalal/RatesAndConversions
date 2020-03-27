package aze.talmir.task.ratesconversions.data.remotesource

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RatesConversionsRepository(
    private val ratesConversionsRemoteDataSource: IRatesConversionsDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IRatesConversionsRepository {

    override suspend fun getRates(base: String, coefficient: Double) =
        withContext(ioDispatcher) {
            return@withContext ratesConversionsRemoteDataSource.getRates(base, coefficient)
        }
}
