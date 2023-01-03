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
import com.example.myecommarce.data.api.StartingViewModel
import dagger.hilt.android.AndroidEntryPoint

class Login : Fragment() {

    private var viewModel:StartingViewModel?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(requireActivity()).get(StartingViewModel::class.java)
        viewModel?.Login("",  "")

        return inflater.inflate(R.layout.fragment_login, container, false)
    }








}