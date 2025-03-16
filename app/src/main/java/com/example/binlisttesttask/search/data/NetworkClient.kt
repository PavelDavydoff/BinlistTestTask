package com.example.binlisttesttask.search.data

interface NetworkClient {
    suspend fun doRequest(dto: Any): Response
}