package com.example.myecommarce.di

import android.content.Context
import com.example.myecommarce.data.api.RetrofitInstance
import com.example.myecommarce.data.repos.Auth.AuthRepositryimpl
import com.example.myecommarce.data.api.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class modules {


    @Provides
    fun getRetrofitService(): ApiServices = getRetrofit().auth

    @Provides
    fun getRetrofit(): RetrofitInstance = RetrofitInstance

    @Provides
    fun getRepositry(@ApplicationContext context: Context): AuthRepositryimpl {
        return AuthRepositryimpl(getRetrofitService(), context)
    }


}