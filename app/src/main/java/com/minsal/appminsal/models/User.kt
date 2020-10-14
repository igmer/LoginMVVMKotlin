package com.minsal.appminsal.models

import androidx.databinding.BaseObservable

class User (private var email: String, private  var password: String): BaseObservable() {

     fun getPassword(): String{
        return  password
    }

     fun getEmail(): String{
        return  email
    }

    fun setEmail(email: String){
        this.email=email
    }
    fun setPassword(password: String){
        this.password=password
    }
}