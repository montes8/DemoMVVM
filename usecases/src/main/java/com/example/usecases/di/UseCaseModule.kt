package com.example.usecases.di

import com.example.usecases.usecases.ProductUseCase
import com.example.usecases.usecases.UserDBUseCase
import org.koin.dsl.module

val usecaseModule = module {
    single { ProductUseCase(get()) }
    single { UserDBUseCase(get()) }

}