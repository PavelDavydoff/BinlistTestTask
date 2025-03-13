package com.example.binlisttesttask.search.domain

import com.example.binlisttesttask.search.data.Response

class BinInteractorImpl(private val repository: Repository) : BinInteractor {
    override suspend fun searchBin(expression: String): Response {
       return repository.searchBin(expression)
    }
}