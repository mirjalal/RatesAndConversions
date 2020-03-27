package aze.talmir.task.ratesconversions.di

import aze.talmir.task.ratesconversions.ServiceLocator
import aze.talmir.task.ratesconversions.ui.main.RatesConversionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    // ViewModel instance of RatesConversionsViewModel
    // get() will resolve IRatesConversionsRepository instance
    viewModel { RatesConversionsViewModel(get()) }

    // single instance of IRatesConversionsRepository
    single { ServiceLocator.provideRatesConversionsRepository() }
}
