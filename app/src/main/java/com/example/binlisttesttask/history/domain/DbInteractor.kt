package com.example.binlisttesttask.history.domain

import com.example.binlisttesttask.history.domain.models.Bin
import com.example.binlisttesttask.search.domain.models.BinResponse
import kotlinx.coroutines.flow.Flow

interface DbInteractor {
    fun addBin(binResponse: BinResponse, binNumber: Int)
    fun getBins(): Flow<List<Bin>>
}