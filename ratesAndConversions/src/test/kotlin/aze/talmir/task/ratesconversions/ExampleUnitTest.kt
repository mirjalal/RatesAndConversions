package aze.talmir.task.ratesconversions

import aze.talmir.task.ratesconversions.data.remotesource.network.RatesConversionsApiModel
import kotlin.reflect.full.memberProperties
import kotlinx.coroutines.ObsoleteCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @ObsoleteCoroutinesApi
    @Test
    fun addition_isCorrect() {
        val r = RatesConversionsApiModel.Rates()
        for (prop in RatesConversionsApiModel.Rates::class.memberProperties)
            println("${prop.name} = ${prop.get(r)}")
//        var i = 0
//        runBlocking {
//            val t = ticker(1_000, 0)
//            for (e in t) {
//                i += 1
//                println(i)
//            }
//        }
        assertEquals(4, 2 + 2)
    }
}
