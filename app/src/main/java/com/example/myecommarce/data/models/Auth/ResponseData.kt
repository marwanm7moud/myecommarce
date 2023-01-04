package com.example.myecommarce.data.models.Auth

data class ResponseData(
    val id:Int,
    val name:String,
    val email:String,
    val phone:String,
    val image:String,
    val points:Int?,
    val credit:Int?,
    val token:String,
)
