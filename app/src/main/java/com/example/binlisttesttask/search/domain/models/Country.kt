package com.example.binlisttesttask.search.domain.models

data class Country(
    val numeric: String,
    val alpha2: String,
    val name: String,
    val emoji: String,
    val currency: String,
    val latitude: Long,
    val longitude: Long
)