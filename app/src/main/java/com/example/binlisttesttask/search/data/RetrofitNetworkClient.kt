package com.example.binlisttesttask.search.data

import com.example.binlisttesttask.search.domain.models.BinResponse
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitNetworkClient : NetworkClient {
    private val baseUrl = "https://lookup.binlist.net/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(API::class.java)

    override suspend fun doRequest(dto: Any): Response {
        return if (dto is SearchRequest) {
            try {
                val resp = service.getBin(dto.expression)
                resp.apply { resultCode = 200 }
            } catch (e: HttpException) {
                BinResponse("", "", "", false, null, null).apply { resultCode = e.code() }
            } catch (e: Exception) {
                BinResponse("", "", "", false, null, null).apply { resultCode = 500 }
            }
        } else {
            BinResponse("", "", "", false, null, null).apply { resultCode = 400 }
        }
    }
}