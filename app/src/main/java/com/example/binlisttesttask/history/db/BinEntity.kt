package com.example.binlisttesttask.history.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_table")
data class BinEntity(
    @PrimaryKey
    val bin: Int,
    val scheme: String,
    val type: String,
    val brand: String,
    val country: String?,
    val bank: String?
)
