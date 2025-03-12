package com.example.binlisttesttask.search.data

interface NetworkClient {
    fun doRequest(dto: Any): Response
}