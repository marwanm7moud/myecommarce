package com.example.myecommarce.di

import android.content.Context
import com.example.myecommarce.data.api.RetrofitInstance
import com.example.myecommarce.data.api.RetrofitRepositry
import com.example.myecommarce.data.api.RetrofitServices
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class modules {


    @Provides
    fun getRetrofitService():RetrofitServices = getRetrofit().auth

    @Provides
    fun getRetrofit():RetrofitInstance = RetrofitInstance

    @Provides
    fun getRepositry(@ApplicationContext context: Context):RetrofitRepositry {
       return RetrofitRepositry(context = context,getRetrofitService() )
    }



}