package com.example.myecommarce.data.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myecommarce.ui.starting.auth.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartingViewModel @Inject constructor(val repositry: RetrofitRepositry):ViewModel() {

    fun Login(email:String, password:String) = viewModelScope.launch {
        repositry.Login(email , password)
    }

}