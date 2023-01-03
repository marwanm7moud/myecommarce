package com.example.myecommarce.data.models

data class LoginResponse(
    val status:Boolean,
    val message:String,
    val data:LoginData
)
