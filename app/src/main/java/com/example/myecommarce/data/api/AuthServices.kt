package com.example.myecommarce.data.api

import com.example.myecommarce.data.models.Auth.LoginBody
import com.example.myecommarce.data.models.Auth.AuthResponse
import com.example.myecommarce.data.models.Auth.RegisterBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST


interface AuthServices {
    @Headers(
        "Content-Type: application/json",
        "lang: en"
    )
    @POST("login")
    fun createLogin(@Body loginBody: LoginBody):Call<AuthResponse>

    @Headers(
        "Content-Type: application/json",
        "lang: en"
    )
    @POST("register")
    fun createRegister(@Body registerBody: RegisterBody):Call<AuthResponse>

    @Headers(
        "Content-Type: application/json",
        "lang: en"
    )
    @GET("profile")
    fun getProfile(@Header("Authorization")token:String):Call<AuthResponse>

    @Headers(
        "Content-Type: application/json",
        "lang: en"
    )
    @POST("logout")
    fun createLogout(@Header("Authorization")token:String):Call<AuthResponse>


}