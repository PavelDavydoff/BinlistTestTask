package com.example.binlisttesttask.search.domain

import com.example.binlisttesttask.search.data.Response

interface BinInteractor {
    suspend fun searchBin(expression: String): Response
}