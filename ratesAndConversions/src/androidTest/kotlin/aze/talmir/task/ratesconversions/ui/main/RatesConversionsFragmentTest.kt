package aze.talmir.task.ratesconversions.ui.main

// import androidx.fragment.app.testing.launchFragment
// import androidx.fragment.app.testing.launchFragmentInContainer
// import androidx.lifecycle.Lifecycle
// import androidx.test.ext.junit.runners.AndroidJUnit4
// import androidx.test.filters.MediumTest
// import androidx.test.rule.ActivityTestRule
// import aze.talmir.task.ratesconversions.MainCoroutineRule
// import aze.talmir.task.ratesconversions.ServiceLocator
// import aze.talmir.task.ratesconversions.data.FakeRateConversionRepository
// import aze.talmir.task.ratesconversions.data.IRatesConversionsRepository
// import aze.talmir.task.ratesconversions.ui.MainActivity
// import kotlinx.coroutines.ExperimentalCoroutinesApi
// import kotlinx.coroutines.ObsoleteCoroutinesApi
// import kotlinx.coroutines.test.runBlockingTest
// import org.junit.After
// import org.junit.Before
// import org.junit.Rule
// import org.junit.Test
// import org.junit.runner.RunWith

/**
 * BECAUSE OF SIMPLE launchFragmentInContainer FUNCTION FAILS,
 * I COULD NOT CONTINUE TESTING INTEGRATION TESTS ANYMORE.
 * However, I wrote necessary codes below (like steps).
 *
 * p.s. I'm getting same error also happens with my other application.
 *
 * the error is:
 * java.lang.AssertionError:
 * Activity never becomes requested state "[CREATED, STARTED, RESUMED, DESTROYED]"
 * (last lifecycle transition = "PRE_ON_CREATE")
 */
// @RunWith(AndroidJUnit4::class)
// @MediumTest
// class RatesConversionsFragmentTest {

//    private lateinit var fakeRepository: IRatesConversionsRepository
//
//    @ExperimentalCoroutinesApi
//    @get:Rule
//    var mainCoroutineRule = MainCoroutineRule()
//
//    @Before
//    fun setUp() {
//        fakeRepository = FakeRateConversionRepository()
//        ServiceLocator.ratesConversionsRepository = fakeRepository
//    }
//
//    @After
//    fun tearDown() {
//        ServiceLocator.resetRepository()
//    }

//    @ObsoleteCoroutinesApi
//    @ExperimentalCoroutinesApi
//    @Test
//    fun runTest() /*= mainCoroutineRule.runBlockingTest*/ {
//        val scenario =
//            launchFragment<RatesConversionsFragment>()
//        FragmentScenario.launchInContainer(RatesConversionsFragment::class.java).moveToState(Lifecycle.State.RESUMED)
//    }
// }
