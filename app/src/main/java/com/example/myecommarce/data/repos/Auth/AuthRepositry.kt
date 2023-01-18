package com.example.myecommarce.data.repos.Auth

import android.media.Image
import android.media.Session2Token
import com.example.myecommarce.data.models.Auth.AuthResponse
import retrofit2.Call

interface AuthRepositry {

    suspend fun login(email:String, password:String)
    suspend fun register(name:String , phone:String , email: String,password: String,image: String)
    suspend fun getProfile(token: String?)
    suspend fun logout(token: String)

}