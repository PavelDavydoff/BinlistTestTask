package com.example.binlisttesttask.search.data

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
                if (resp != null) {
                    resp.apply { resultCode = 200 }
                } else {
                    Response().apply { resultCode = 204 } // No Content
                }
            } catch (e: HttpException) {
                Response().apply { resultCode = e.code() }
            } catch (e: Exception) {
                Response().apply { resultCode = 500 } // Internal Server Error
            }
        } else {
            Response().apply { resultCode = 400 } // Bad Request
        }
    }
}