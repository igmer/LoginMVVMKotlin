package com.minsal.appminsal.data.respository

import com.minsal.appminsal.data.Userpreferences
import com.minsal.appminsal.data.network.AuthApi

class AuthRepository(
    private  val api: AuthApi,
    private val preferences: Userpreferences
) : BaseRepository() {
    suspend fun login(username: String, password: String) = safeApiCall {
        api.loggin(username,password)
    }
    suspend fun saveAuthToken(token: String){
        preferences.saveToken(token)
    }
}