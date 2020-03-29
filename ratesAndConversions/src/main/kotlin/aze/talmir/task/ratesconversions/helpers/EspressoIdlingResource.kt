package aze.talmir.task.ratesconversions.helpers

//import androidx.test.espresso.idling.CountingIdlingResource

/**
 * Two main idling resources exist:
 * CountingIdlingResource and DataBindingIdlingResource.
 *
 * The first one is useful for long running db and network
 * operations, another one is for to stay in sync espresso
 * with a data binding.
 *
 * p.s. could be uncommented after the pointed errors fixed...
 */
//object EspressoIdlingResource {
//
//    @JvmField
//    val countingIdlingResource = CountingIdlingResource("GLOBAL")
//
//    fun increment() =
//        countingIdlingResource.increment() // accessed when app is in its work
//
//    fun decrement() {
//        if (!countingIdlingResource.isIdleNow)
//            countingIdlingResource.decrement() // app is not doing anything
//    }
//}
//
//inline fun <T> wrapEspressoIdlingResource(block: () -> T): T {
//    // Espresso does not work well with coroutines yet. See
//    // https://github.com/Kotlin/kotlinx.coroutines/issues/982
//    EspressoIdlingResource.increment() // Set app as busy.
//    return try {
//        block()
//    } finally {
//        EspressoIdlingResource.decrement() // Set app as idle.
//    }
//}
