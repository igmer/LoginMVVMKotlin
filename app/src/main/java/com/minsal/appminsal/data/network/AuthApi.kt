package com.minsal.appminsal.data.network

import com.minsal.appminsal.data.responses.ResponseLogin
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
    @FormUrlEncoded
    @POST("api/login_check")
    suspend fun loggin(
        @Field("_username") username: String,
        @Field("_password") password: String
    ) : ResponseLogin

}