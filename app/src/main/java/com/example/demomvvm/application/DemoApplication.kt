package com.example.demomvvm.application


import android.app.Application
import com.example.demomvvm.di.viewModelsModule
import com.example.repository.database.di.databaseModule
import com.example.repository.network.di.networkModule
import com.example.usecases.di.usecaseModule
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import pe.solera.repository.network.utils.BASE_URL
import pe.solera.repository.preference.di.preferencesModule


class DemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@DemoApplication)
                    modules(listOf(viewModelsModule, usecaseModule, networkModule, databaseModule, preferencesModule))
        }
        getKoin().setProperty(BASE_URL, "https://mantenimientogalaxy.herokuapp.com/api/")
    }
}