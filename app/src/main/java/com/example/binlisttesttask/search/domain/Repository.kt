package com.example.binlisttesttask.search.domain

import com.example.binlisttesttask.search.domain.models.BinResponse

interface Repository {
    suspend fun searchBin(expression: String): BinResponse?
}