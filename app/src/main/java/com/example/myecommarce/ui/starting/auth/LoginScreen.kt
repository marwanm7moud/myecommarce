package com.example.myecommarce.ui.starting.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myecommarce.R

class Login : Fragment() {

    private var viewModel:AuthViewModel?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(requireActivity()).get(AuthViewModel::class.java)
        viewModel?.login("algazzar.abdelra55hman@gmail.com" , "123456")
        Log.d("marwan" , "done")
        return inflater.inflate(R.layout.fragment_login, container, false)
    }








}