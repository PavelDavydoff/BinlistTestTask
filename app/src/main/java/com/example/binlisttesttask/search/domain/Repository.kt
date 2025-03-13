package com.example.binlisttesttask.search.domain

import com.example.binlisttesttask.search.data.Response

interface Repository {
    suspend fun searchBin(expression: String): Response
}