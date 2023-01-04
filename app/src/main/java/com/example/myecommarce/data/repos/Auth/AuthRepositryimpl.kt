package com.example.myecommarce.data.repos.Auth

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.myecommarce.data.api.ApiServices
import com.example.myecommarce.data.models.Auth.LoginBody
import com.example.myecommarce.data.models.Auth.AuthResponse
import com.example.myecommarce.data.models.Auth.RegisterBody
import com.example.myecommarce.utils.Components
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthRepositryimpl @Inject constructor(
    val retrofitServices: ApiServices,
    val context: Context
) : AuthRepositry {

    var authResponse:MutableLiveData<AuthResponse?> = MutableLiveData()




    override suspend fun login(email: String, password: String) {
        val loginBody = LoginBody(email, password)
        val response = retrofitServices.createLogin(loginBody)
        response.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful && response.body()?.status == true) {
                    authResponse.postValue(response.body())
                    Components.setToken(context , response.body()!!.data.token)
                }else{
                    Components.makeToast(context , response.message())
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                authResponse.postValue(null)

            }

        })
    }

    override suspend fun register(name: String, phone: String, email: String, password: String, image: String) {
        val registerBody = RegisterBody(name, phone, email, password, image)
        val response = retrofitServices.createRegister(registerBody)
        response.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful && response.body()?.status == true) {
                    authResponse.postValue(response.body())
                    Components.setToken(context , response.body()!!.data.token)
                }else{
                    Components.makeToast(context , response.message())
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                authResponse.postValue(null)
            }

        })
    }

    override suspend fun getProfile(token: String?) {
        val response = token?.let { retrofitServices.getProfile(it) }
        if (response != null) {
            response.enqueue(object : Callback<AuthResponse> {
                override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                    if (response.isSuccessful && response.body()?.status == true) {
                        authResponse.postValue(response.body())
                        Components.setToken(context , response.body()!!.data.token)
                    }
                }

                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                    authResponse.postValue(null)
                }

            }
            )
        }
    }




}