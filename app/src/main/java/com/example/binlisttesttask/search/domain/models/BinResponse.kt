package com.example.binlisttesttask.search.domain.models

import com.example.binlisttesttask.search.data.Response

data class BinResponse(
    val number: Number?,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean?,
    val country: Country?,
    val bank: Bank?
): Response() {
}