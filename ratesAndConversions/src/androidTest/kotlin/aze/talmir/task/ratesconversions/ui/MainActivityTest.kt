package aze.talmir.task.ratesconversions.ui

// import androidx.test.core.app.ActivityScenario
// import androidx.test.espresso.Espresso.onView
// import androidx.test.espresso.IdlingRegistry
// import androidx.test.espresso.IdlingResource
// import androidx.test.espresso.assertion.ViewAssertions.matches
// import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
// import androidx.test.espresso.matcher.ViewMatchers.withText
// import androidx.test.ext.junit.runners.AndroidJUnit4
// import androidx.test.filters.LargeTest
// import androidx.test.rule.ActivityTestRule
// import aze.talmir.task.ratesconversions.ServiceLocator
// import aze.talmir.task.ratesconversions.data.IRatesConversionsRepository
// import aze.talmir.task.ratesconversions.helpers.DataBindingIdlingResource
// import aze.talmir.task.ratesconversions.helpers.EspressoIdlingResource
// import aze.talmir.task.ratesconversions.helpers.monitorActivity
// import kotlinx.coroutines.runBlocking
// import org.junit.After
// import org.junit.Before
// import org.junit.Rule
// import org.junit.Test
// import org.junit.runner.RunWith

/**
 * End-to-end tests should be located right here!
 * However, because of the androidx.test issues,
 * I cannot even finish successfully the simple line:
 * `ActivityScenario.launch(MainActivity::class.java)` !
 *
 * The problem same as which for the fragment testing.
 * Don't know why but neither fragment nor activity is
 * not changing its lifecycle state during the tests...
 * I have googled for that problem, but couldn't be able
 * to find proper solution for my case(s). Btw, I said
 * `cases` because the similar problem is currently
 * happening my own application.
 *
 * I am very sorry for that I could not continue writing
 * either integration or end-to-end tests... I apologize.
 */
// @RunWith(AndroidJUnit4::class)
// @LargeTest
// class MainActivityTest {
//
//    @Rule
//    @JvmField var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
//
//    private fun getActivity() = activityRule.activity
//
//    private lateinit var repo: IRatesConversionsRepository
//
//    @Before
//    fun setupRepo() {
//        repo = ServiceLocator.provideRatesConversionsRepository()
//    }
//
//    @After
//    fun resetRepo() = ServiceLocator.resetRepository()
//
//    private val dataBindingIdlingResource = DataBindingIdlingResource()
//
//    @Before
//    fun setupIdlingResources() {
//        IdlingRegistry.getInstance().run {
//            register(dataBindingIdlingResource)
//            register(EspressoIdlingResource.countingIdlingResource)
//        }
//    }
//
//    @After
//    fun resetIdlingResources() {
//        IdlingRegistry.getInstance().run {
//            unregister(dataBindingIdlingResource)
//            unregister(EspressoIdlingResource.countingIdlingResource)
//        }
//    }
//
//    @Test
//    fun getRates(): Unit = runBlocking {
//        // initial state
//        repo.getRates("EUR", 1.0)
//
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//        dataBindingIdlingResource.monitorActivity(activityScenario)
//
//        // espresso codes...
//        onView(withText("EUR")).check(matches(isDisplayed()))
//
//
//        // finish the activity
//        getActivity().finishActivity(1)
//    }
// }
