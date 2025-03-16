package com.example.binlisttesttask.history.di

import com.example.binlisttesttask.history.ui.HistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val historyViewModelModule = module {
    viewModel {
        HistoryViewModel(get())
    }
}