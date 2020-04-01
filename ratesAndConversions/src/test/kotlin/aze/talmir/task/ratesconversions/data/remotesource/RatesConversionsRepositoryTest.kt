package aze.talmir.task.ratesconversions.data.remotesource

import aze.talmir.task.ratesconversions.MainCoroutineRule
import aze.talmir.task.ratesconversions.data.remotesource.network.RatesConversionsApiModel
import aze.talmir.task.ratesconversions.data.repo.RatesConversionsRepository
import aze.talmir.task.ratesconversions.helpers.Result
import aze.talmir.task.ratesconversions.helpers.asCurrencyData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RatesConversionsRepositoryTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val fakeApiData = RatesConversionsApiModel(
        "EUR",
        RatesConversionsApiModel.Rates(
            1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
            1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
            1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
            1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0
        )
    )

    private lateinit var ratesConversionsRemoteDataSource: FakeRemoteDataSource

    // class under test
    private lateinit var ratesConversionsRepository: RatesConversionsRepository

    @Before
    fun setUpRepository() {
        ratesConversionsRemoteDataSource = FakeRemoteDataSource(fakeApiData)

        ratesConversionsRepository =
            RatesConversionsRepository(
                ratesConversionsRemoteDataSource,
                Dispatchers.Main // because of the coroutine rule is a test coroutine dispatcher, I can use Main dispatcher
            )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getRatesConversionData_requestFromRemoteDataSource() = mainCoroutineRule.runBlockingTest {
        // when rates are requested from the repository
        val rates =
            ratesConversionsRepository.getRates("EUR", 1.0.toBigDecimal()) as Result.Success

        // then rates are loaded from the remote data source
        // because of Kotlin Sequences are not values,
        // so equality doesn't really make sense for sequences.
        // Thus, toList() applied.
        assertThat(rates.data.toList(), IsEqual(fakeApiData.asCurrencyData(1.0.toBigDecimal()).toList()))
    }
}
