package aze.talmir.task.ratesconversions.data.remotesource

import aze.talmir.task.ratesconversions.data.IRatesConversionsDataSource
import aze.talmir.task.ratesconversions.helpers.Result
import aze.talmir.task.ratesconversions.data.remotesource.network.RatesConversionsApiModel

class FakeRemoteDataSource(
    private val ratesConversionsApiModel: RatesConversionsApiModel? = RatesConversionsApiModel()
) : IRatesConversionsDataSource {
    override suspend fun getRates(base: String): Result<RatesConversionsApiModel> {
        ratesConversionsApiModel?.let { return Result.Success(it) }
        return Result.Error("No data got from API")
    }
}
