package com.minsal.appminsal.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minsal.appminsal.data.network.Resources
import com.minsal.appminsal.data.responses.ResponseLogin
import com.minsal.appminsal.data.respository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel() {
    private val _loginResponse: MutableLiveData<Resources<ResponseLogin>> = MutableLiveData()
    val loginResponse: LiveData<Resources<ResponseLogin>>
    get() = _loginResponse
    fun login(username: String, password: String) = viewModelScope.launch {
       _loginResponse.value = repository.login(username,password)
    }
    fun saveAuthToken(token: String) = viewModelScope.launch{
        repository.saveAuthToken(token)

    }
}