package com.example.binlisttesttask.search.di

import com.example.binlisttesttask.search.ui.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchViewModelModule = module {
    viewModel {
        SearchViewModel(get())
    }
}