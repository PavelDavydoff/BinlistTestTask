package com.example.binlisttesttask.search.domain

import com.example.binlisttesttask.search.domain.models.BinResponse

class BinInteractorImpl(private val repository: Repository) : BinInteractor {
    override fun searchBin(expression: String): BinResponse {
       return repository.searchBin(expression)
    }
}