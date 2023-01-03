package com.example.myecommarce.utils

import android.content.Context
import android.content.SharedPreferences
import android.view.View

object Components {
    private const val MY_PREF:String="mypref"
    const val ON_BOARDING:String = "onboarding"
    const val BASE_URL:String = "https://student.valuxapps.com/api/"

    fun getSharedPref(context: Context):SharedPreferences{
        return context.getSharedPreferences(MY_PREF , Context.MODE_PRIVATE)

    }
}