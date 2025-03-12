package com.example.binlisttesttask.search.data

import com.example.binlisttesttask.search.domain.models.BinResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    @GET("{bin}")
    suspend fun getBin(@Path("bin") text: String) : BinResponse
}