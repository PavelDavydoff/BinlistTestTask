package com.example.binlisttesttask.history.di

import com.example.binlisttesttask.history.data.DbConverter
import com.example.binlisttesttask.history.data.DbRepositoryImpl
import com.example.binlisttesttask.history.domain.DbInteractor
import com.example.binlisttesttask.history.domain.DbInteractorImpl
import com.example.binlisttesttask.history.domain.DbRepository
import org.koin.dsl.module

val historyModule = module {
    factory {
        DbConverter()
    }
    factory<DbRepository> {
        DbRepositoryImpl(get(), get())
    }
    factory<DbInteractor> {
        DbInteractorImpl(get())
    }
}