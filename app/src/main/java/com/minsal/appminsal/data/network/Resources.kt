package com.minsal.appminsal.data.network

import okhttp3.ResponseBody

sealed class Resources<out T> {
    data class Success<out T>(val value: T) : Resources<T>()
    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : Resources<Nothing>()

}