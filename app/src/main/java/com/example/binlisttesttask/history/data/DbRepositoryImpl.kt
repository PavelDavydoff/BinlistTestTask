package com.example.binlisttesttask.history.data

import com.example.binlisttesttask.history.db.AppDatabase
import com.example.binlisttesttask.history.domain.Bin
import com.example.binlisttesttask.history.domain.DbRepository
import com.example.binlisttesttask.search.domain.models.BinResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DbRepositoryImpl(private val database: AppDatabase, private val dbConverter: DbConverter) :
    DbRepository {
    override fun addBin(bin: BinResponse) {
        database.binDao().insertBin(dbConverter.map(bin))
    }

    override fun getBins(): Flow<List<Bin>> =
        database.binDao().getBins().map { bins -> bins.map { dbConverter.map(it) } }
}