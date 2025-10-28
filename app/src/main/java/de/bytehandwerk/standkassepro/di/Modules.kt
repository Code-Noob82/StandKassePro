package de.bytehandwerk.standkassepro.di

import de.bytehandwerk.standkassepro.data.repo.ArticleRepository
import de.bytehandwerk.standkassepro.data.store.SettingsStore
import de.bytehandwerk.standkassepro.viewModel.CashRegisterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { SettingsStore(androidContext()) }
    single { ArticleRepository(get()) }
    viewModel { CashRegisterViewModel(get()) }
}