package com.example.myecommarce.ui.starting.auth

import android.view.View
import com.example.myecommarce.data.models.Auth.AuthResponse

interface AuthValidation {

    fun onLoading(view: View)
    fun onSuccess(view: View , authResponse: AuthResponse)
    fun onLoadingDone(view: View)
    fun onWrongInput(view: View, authResponse: AuthResponse)

}