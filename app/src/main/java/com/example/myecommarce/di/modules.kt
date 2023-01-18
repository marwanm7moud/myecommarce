package com.example.myecommarce.di

import com.example.myecommarce.data.api.RetrofitInstance
import com.example.myecommarce.data.repos.Auth.AuthRepositryimpl
import com.example.myecommarce.data.api.AuthServices
import com.example.myecommarce.data.api.ProductServices
import com.example.myecommarce.data.repos.main.MainRepositry
import com.example.myecommarce.data.repos.main.MainRepositryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class modules {

    @Provides
    fun getAuthService(): AuthServices = getRetrofit().auth
    @Provides
    fun getProductService(): ProductServices = getRetrofit().product

    @Provides
    fun getRetrofit(): RetrofitInstance = RetrofitInstance

    @Provides
    fun getAuthRepositry(): AuthRepositryimpl {
        return AuthRepositryimpl(getAuthService())
    }
    @Provides
    fun getMainRepositry(): MainRepositryImpl {
        return MainRepositryImpl(getProductService())
    }



}