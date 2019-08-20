package com.example.demomvvm.di



import com.example.demomvvm.ui.home.ProductViewModel
import com.example.demomvvm.ui.signin.SigninViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ProductViewModel(get(),get()) }
    viewModel { SigninViewModel(get(),get()) }
}