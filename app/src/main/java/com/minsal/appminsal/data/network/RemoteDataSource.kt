package com.minsal.appminsal.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RemoteDataSource {
    companion object {
        private const val BASE_URL = "httpmisitio/"
    }

    fun <Api> buildApi(api: Class<Api>): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().also { client ->
                val loggin = HttpLoggingInterceptor()
                loggin.setLevel(HttpLoggingInterceptor.Level.BODY)
                client.addInterceptor(loggin)

            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)


    }
}