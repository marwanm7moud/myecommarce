package com.example.myecommarce.utils

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.widget.Toast

object Components {
    private const val MY_PREF:String="mypref"
    const val ON_BOARDING:String = "onboarding"
    const val BASE_URL:String = "https://student.valuxapps.com/api/"
    const val TOKEN:String = "token"
    var theToken:String?=null

    fun getSharedPref(context: Context):SharedPreferences{
        return context.getSharedPreferences(MY_PREF , Context.MODE_PRIVATE)
    }
    fun getToken(context: Context){
        val sharedpref = getSharedPref(context)
        theToken = sharedpref.getString(TOKEN , null)
    }
    fun setToken(context: Context , token:String){
        val edit = getSharedPref(context).edit()
        edit.putString(TOKEN , token)
        edit.commit()

    }
    fun makeToast(context: Context , message:String){
        Toast.makeText(context , message , Toast.LENGTH_SHORT).show()
    }
}