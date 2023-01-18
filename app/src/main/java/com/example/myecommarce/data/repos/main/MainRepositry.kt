package com.example.myecommarce.data.repos.main

interface MainRepositry {

    suspend fun getBanners()
    suspend fun getCategories(token:String)
    suspend fun getCategoriesProduct(token:String , id:Int)

}