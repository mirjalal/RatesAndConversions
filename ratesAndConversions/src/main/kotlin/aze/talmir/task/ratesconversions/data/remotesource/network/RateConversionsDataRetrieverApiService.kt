package aze.talmir.task.ratesconversions.data.remotesource.network

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * A public interface that exposes the [getRateConversions] methods.
 */
interface RateConversionsDataRetrieverService {
    /**
     * A suspendable function to be executed
     * to get rate & conversions data for
     * different currencies.
     */
    @GET("api/android/latest")
    suspend fun getRateConversions(
        @Query("base") baseCurrency: String
    ): retrofit2.Response<RatesConversionsApiModel>
}

/**
 * An object that represents [rateConversionsDataRetrieverApiService]
 * to consume eDoc verification service.
 */
object RateConversionsRemoteDataRetrieverApi {
    val rateConversionsDataRetrieverApiService: RateConversionsDataRetrieverService by lazy {
        retrofit.create(RateConversionsDataRetrieverService::class.java)
    }
}
