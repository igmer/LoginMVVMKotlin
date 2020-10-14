package com.minsal.appminsal.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.minsal.appminsal.data.respository.AuthRepository
import com.minsal.appminsal.data.respository.BaseRepository
import com.minsal.appminsal.ui.auth.AuthViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private  val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  when{
         modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            else -> throw  IllegalArgumentException("VM class not foud")
        }
    }
}