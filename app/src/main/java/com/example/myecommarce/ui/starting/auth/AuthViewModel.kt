package com.example.myecommarce.ui.starting.auth

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myecommarce.data.models.Auth.AuthResponse
import com.example.myecommarce.data.repos.Auth.AuthRepositryimpl
import com.example.myecommarce.utils.Components
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.*
import okhttp3.Dispatcher
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class AuthViewModel @Inject constructor(val repositry: AuthRepositryimpl ,@ApplicationContext context: Context ) : ViewModel() {

    var authResponse:MutableLiveData<AuthResponse?> = MutableLiveData()

    init {
        authResponse = repositry.authResponse
        getProfile(Components.theToken)
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repositry.login(email, password)
        }
    }

    fun register(name: String, phone: String, email: String, password: String, image: String) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repositry.register(name, phone, email, password, image)
        }
    }
    fun getProfile(token:String?)= viewModelScope.launch {
        withContext(Dispatchers.IO){
            repositry.getProfile(token)
        }
    }
    fun logout(token:String)= viewModelScope.launch {
        withContext(Dispatchers.IO){
            repositry.logout(token)
        }
    }
}