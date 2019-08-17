package pe.solera.repository.preference.di

import com.kkroco.repository.preference.manager.PreferencesManager
import org.koin.dsl.module


val preferencesModule = module {
    single { PreferencesManager(get()) }
}