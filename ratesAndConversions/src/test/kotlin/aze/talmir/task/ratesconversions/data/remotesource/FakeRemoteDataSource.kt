package aze.talmir.task.ratesconversions.data.remotesource

import aze.talmir.task.ratesconversions.data.IRatesConversionsDataSource
import aze.talmir.task.ratesconversions.data.remotesource.network.RatesConversionsApiModel
import aze.talmir.task.ratesconversions.helpers.Result

class FakeRemoteDataSource(
    private val ratesConversionsApiModel: RatesConversionsApiModel? = RatesConversionsApiModel()
) : IRatesConversionsDataSource {
    override suspend fun getRates(base: String): Result<RatesConversionsApiModel> {
        ratesConversionsApiModel?.let { return Result.Success(it) }
        return Result.Error("No data got from API")
    }
}
