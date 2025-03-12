package com.example.binlisttesttask.search.data

import com.example.binlisttesttask.search.domain.Repository
import com.example.binlisttesttask.search.domain.models.BinResponse

class RepositoryImpl(private val networkClient: NetworkClient) : Repository {
    override fun searchBin(expression: String): BinResponse {
        val response = networkClient.doRequest(SearchRequest(expression))
        if (response.resultCode == 200) {
            return (response as BinResponse)
        } else return BinResponse("0", "0", "0", false, null, null)
    }
}