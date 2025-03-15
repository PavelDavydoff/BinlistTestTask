package com.example.binlisttesttask.history.domain

import com.example.binlisttesttask.search.domain.models.BinResponse
import kotlinx.coroutines.flow.Flow

class DbInteractorImpl(private val dbRepository: DbRepository) : DbInteractor {
    override fun addBin(binResponse: BinResponse, binNumber: Int) {
        dbRepository.addBin(binResponse, binNumber)
    }

    override fun getBins(): Flow<List<Bin>> {
        return dbRepository.getBins()
    }
}