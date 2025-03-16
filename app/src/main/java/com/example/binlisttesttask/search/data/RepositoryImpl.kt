package com.example.binlisttesttask.search.data

import com.example.binlisttesttask.search.domain.Repository
import com.example.binlisttesttask.search.domain.models.BinResponse

class RepositoryImpl(private val networkClient: NetworkClient) : Repository {
    override suspend fun searchBin(expression: String): Response {
        return networkClient.doRequest(SearchRequest(expression))
    }
}