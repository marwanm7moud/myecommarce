package com.example.myecommarce.data.repos.main

import androidx.lifecycle.MutableLiveData
import com.example.myecommarce.data.api.ProductServices
import com.example.myecommarce.data.models.main.Categories.CategoriesResponse
import com.example.myecommarce.data.models.main.Categories.Category
import com.example.myecommarce.data.models.main.Products.ProductResponse
import com.example.myecommarce.data.models.main.banner.BannersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainRepositryImpl @Inject constructor(
   val productServices: ProductServices
) : MainRepositry {

    val banners :MutableLiveData<BannersResponse?> = MutableLiveData()
    val category :MutableLiveData<CategoriesResponse?> = MutableLiveData()
    val categoryProducts :MutableLiveData<ProductResponse?> = MutableLiveData()




    override suspend fun getBanners() {
        val response = productServices.getBanners()
        response.enqueue(object :Callback<BannersResponse>{
            override fun onResponse(
                call: Call<BannersResponse>,
                response: Response<BannersResponse>
            ) {
                if (response.isSuccessful){
                    banners.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<BannersResponse>, t: Throwable) {
                banners.postValue(null)
            }

        })
    }

    override suspend fun getCategories(token: String) {
        val respone = productServices.getCategories(token)
        respone.enqueue(object:Callback<CategoriesResponse>{
            override fun onResponse(
                call: Call<CategoriesResponse>,
                response: Response<CategoriesResponse>
            ) {
                if(response.isSuccessful){
                    category.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
               category.postValue(null)
            }

        })
    }

    override suspend fun getCategoriesProduct(token: String, id: Int) {
        val respone = productServices.getCategoryProducts(token , id)
        respone.enqueue(object:Callback<ProductResponse>{
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
               if (response.isSuccessful){
                   categoryProducts.postValue(response.body())
               }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                categoryProducts.postValue(null)
            }


        })
    }


}