package com.example.myecommarce.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.myecommarce.R
import com.example.myecommarce.data.models.Auth.AuthResponse
import com.example.myecommarce.ui.starting.auth.AuthViewModel
import com.example.myecommarce.utils.Components
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response
@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {

    val viewmodel: AuthViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        viewmodel.authResponse.observe(this , Observer {
            if (it!=null){
                supportActionBar?.title = it.data.name
            }
        })

    }
}