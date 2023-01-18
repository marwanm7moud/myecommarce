package com.example.myecommarce.data.api

import com.example.myecommarce.data.models.main.Categories.CategoriesResponse
import com.example.myecommarce.data.models.main.Products.ProductResponse
import retrofit2.Call
import com.example.myecommarce.data.models.main.banner.BannersResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ProductServices {



    @Headers(
        "lang: en",
    )
    @GET("categories")
    fun getCategories(@Header("Authorization")token:String):Call<CategoriesResponse>

    @Headers(
        "lang: en",
        "Content-Type: application/json"
    )
    @GET("products")
    fun getCategoryProducts(@Header("Authorization")token:String,@Query("category_id")cat_id:Int):Call<ProductResponse>

    @GET("banners")
    fun getBanners():Call<BannersResponse>

}