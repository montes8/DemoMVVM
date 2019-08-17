package com.example.usecases.di

import com.example.usecases.usecases.ProductUseCase
import org.koin.dsl.module

val usecaseModule = module {
    single { ProductUseCase(get()) }

}