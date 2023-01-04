package com.example.myecommarce.ui.starting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myecommarce.R
import com.example.myecommarce.utils.Components
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting)
        supportActionBar?.hide()
        Components.getToken(context = this)
    }
}