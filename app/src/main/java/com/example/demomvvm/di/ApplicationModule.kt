package com.example.demomvvm.di



import com.example.demomvvm.ui.home.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ProductViewModel(get(),get()) }
}