package com.example.myecommarce.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myecommarce.data.models.main.Categories.CategoriesResponse
import com.example.myecommarce.data.models.main.Products.ProductResponse
import com.example.myecommarce.data.models.main.banner.BannersResponse
import com.example.myecommarce.data.repos.main.MainRepositry
import com.example.myecommarce.data.repos.main.MainRepositryImpl
import com.example.myecommarce.utils.Components
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repositry: MainRepositryImpl) :ViewModel(){

    var banners : MutableLiveData<BannersResponse?> = MutableLiveData()
    var category :MutableLiveData<CategoriesResponse?> = MutableLiveData()
    var categoryProducts :MutableLiveData<ProductResponse?> = MutableLiveData()

    init {
        banners = repositry.banners
        category=  repositry.category
        categoryProducts = repositry.categoryProducts
        getBanners()
        getCategory(Components.theToken!!)
    }


    fun getBanners() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            repositry.getBanners()
        }
    }
    fun getCategory(token:String) = viewModelScope.launch {
        withContext(Dispatchers.IO){
            repositry.getCategories(token)
        }
    }
    fun getCategoryProducts(token: String , id:Int) = viewModelScope.launch {
        withContext(Dispatchers.IO){
            repositry.getCategoriesProduct(token, id)
        }
    }

}