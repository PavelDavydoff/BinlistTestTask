package com.example.binlisttesttask.history.di

import androidx.room.Room
import com.example.binlisttesttask.history.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "database.db")
            .allowMainThreadQueries()
            .build()
    }
}