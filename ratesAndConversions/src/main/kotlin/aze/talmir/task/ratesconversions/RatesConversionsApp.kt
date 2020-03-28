package aze.talmir.task.ratesconversions

import android.app.Application
import aze.talmir.task.ratesconversions.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RatesConversionsApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start DI and let it to create instances for us.
        startKoin {
            androidContext(this@RatesConversionsApp)
            modules(appModules)
        }
    }
}
