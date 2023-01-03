package com.example.myecommarce.data.api

import android.content.Context
import android.widget.Toast
import com.example.myecommarce.data.models.LoginBody
import com.example.myecommarce.data.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import javax.inject.Inject

class RetrofitRepositry @Inject constructor(
    val context: Context ,
    val retrofitServices: RetrofitServices
    ) {



    fun Login(email:String, password:String){
        val loginBody = LoginBody(email, password)
        val response=retrofitServices.createLogin(loginBody)
        response.enqueue(object :Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val loginBody=response.body()

                if (response.isSuccessful&&loginBody?.status==true){

                    //add here if all things is ok

                    Toast.makeText(context, "done", Toast.LENGTH_SHORT).show()
                }else
                {
                    //add here if connection is ok but the input wrong
                    Toast.makeText(context, loginBody?.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                //add here if connection is not ok
                Toast.makeText(context , t.message , Toast.LENGTH_SHORT).show()
            }

        })
    }

}