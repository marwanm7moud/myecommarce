package com.example.myecommarce.data.api

import com.example.myecommarce.data.models.LoginBody
import com.example.myecommarce.data.models.LoginResponse
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import okhttp3.MultipartBody
import retrofit2.http.Header


interface RetrofitServices {
    @Headers(
        "Content-Type: application/json",
        "lang: en"
    )
    @POST("login")
    fun createLogin(@Body loginBody: LoginBody):Call<LoginResponse>
}