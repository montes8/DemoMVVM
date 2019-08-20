package com.example.repository.database.di

import androidx.room.Room
import com.example.repository.database.DemoDataBase
import com.example.repository.database.api.UserDataBase
import com.example.usecases.repository.UserRepositoryDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module



val databaseModule: Module = module {
    single {
        Room.databaseBuilder(androidContext(), DemoDataBase::class.java, "demo-db")
            .build()
    }
    single { get<DemoDataBase>().userDao }
    single<UserRepositoryDataBase> { UserDataBase(get()) }


}