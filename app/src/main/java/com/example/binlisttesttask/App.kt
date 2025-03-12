package com.example.binlisttesttask

import android.app.Application
import com.example.binlisttesttask.search.di.searchModule
import com.example.binlisttesttask.search.di.searchViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(searchModule, searchViewModelModule)
        }
    }
}