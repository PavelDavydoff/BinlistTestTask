package com.example.binlisttesttask.history.domain

import com.example.binlisttesttask.search.domain.models.BinResponse
import kotlinx.coroutines.flow.Flow

interface DbRepository {
    fun addBin(bin: BinResponse, binNumber: Int)
    fun getBins(): Flow<List<Bin>>
}