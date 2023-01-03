package com.example.myecommarce.di

import android.content.Context
import com.example.myecommarce.data.api.RetrofitRepositry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class modules {


    @Provides
    fun getRepositry(@ApplicationContext context: Context):RetrofitRepositry {
       return RetrofitRepositry(context = context)
    }

}