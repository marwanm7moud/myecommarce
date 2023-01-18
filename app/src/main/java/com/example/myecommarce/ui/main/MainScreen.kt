package com.example.myecommarce.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myecommarce.R
import com.example.myecommarce.ui.starting.auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_product.*

@AndroidEntryPoint
class MainScreen : AppCompatActivity(){

    val Authviewmodel: AuthViewModel by viewModels()

    val Mainviewmodel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val navController = supportFragmentManager.findFragmentById(R.id.MainNavHost) as NavHostFragment
        bottomNavBar.setupWithNavController(navController.findNavController())



    }


}