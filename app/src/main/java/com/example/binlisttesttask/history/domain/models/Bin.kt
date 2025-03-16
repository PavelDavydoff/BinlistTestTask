package com.example.binlisttesttask.history.domain.models

data class Bin(
    val binNumber: Int,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val country: String?,
    val bank: String?
)