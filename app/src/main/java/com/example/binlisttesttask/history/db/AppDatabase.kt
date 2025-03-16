package com.example.binlisttesttask.history.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 2, entities = [BinEntity::class])
abstract class AppDatabase : RoomDatabase(){
    abstract fun binDao(): BinDao
}