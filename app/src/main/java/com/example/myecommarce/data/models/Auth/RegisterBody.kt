package com.example.myecommarce.data.models.Auth

data class RegisterBody(
    val name:String,
    val phone:String,
    val email:String,
    val password:String,
    val image:String,
)
