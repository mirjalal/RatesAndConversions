package aze.talmir.task.ratesconversions.data.remotesource.network

import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val okHttpClient = OkHttpClient.Builder()
    .connectTimeout(15, TimeUnit.SECONDS)
    .readTimeout(60, TimeUnit.SECONDS)
    .writeTimeout(60, TimeUnit.SECONDS)
    .build()

// Build the Moshi object that Retrofit will be using, making
// sure to add the Kotlin adapter for full Kotlin compatibility.
private val moshiConverterFactory: MoshiConverterFactory = MoshiConverterFactory.create()

/**
 * Use the retrofit builder to build a retrofit object using a moshi
 * converter with our [moshiConverterFactory] object pointing to the desired URL
 */
val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://hiring.revolut.codes/")
    .client(okHttpClient)
    .addConverterFactory(moshiConverterFactory)
    .build()
