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

                if (resp.isSuccessful) {//Вот тут исправить, чтобы не возвращал пустой объект
                    resp.body()?.apply { resultCode = resp.code() } ?: BinResponse(null, "", "", "", null, null, null).apply { resultCode = resp.code() }
                } else {
                    BinResponse(null, "", "", "", null, null, null).apply { resultCode = resp.code() }
                }

            } catch (e: HttpException) {
                BinResponse(null, "", "", "", null, null, null).apply { resultCode = e.code() }
            } catch (e: Exception) {
                BinResponse(null, "", "", "", null, null, null).apply { resultCode = 503 }
            }
        } else {
            BinResponse(null, "", "", "", null, null, null).apply { resultCode = 400 }
        }
    }
}