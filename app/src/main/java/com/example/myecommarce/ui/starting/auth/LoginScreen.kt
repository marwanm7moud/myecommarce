package com.example.myecommarce.ui.starting.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.myecommarce.R
import com.example.myecommarce.data.models.Auth.AuthResponse
import com.example.myecommarce.ui.main.ProductActivity
import com.example.myecommarce.utils.Components
import com.example.myecommarce.utils.EditTextValidation
import kotlinx.android.synthetic.main.fragment_login.view.*

class Login : Fragment(), AuthValidation {

    private var viewModel: AuthViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(AuthViewModel::class.java)

        viewModel!!.authResponse.observe(viewLifecycleOwner, Observer {
            if (it != null) {          //Checking network Error
                if (it.status) {               //Done
                    onSuccess(view, it)
                } else {                        //Wrong Input
                    onWrongInput(view, it)
                }
            } else {
                onLoadingDone(view)
                Components.makeToast(requireActivity(), "Check your network")
            }
        })

        view.login_btn.setOnClickListener {
            val email = view.login_email_et.text.toString()
            val password = view.login_passwrod_et.text.toString()

            if (EditTextValidation.emailEt(email) == null && EditTextValidation.passwordEt(password) == null) {
                onLoading(view)
                viewModel!!.login(email, password)
            } else {
                view.login_email_et.error = EditTextValidation.emailEt(email)
                view.login_passwrod_et.error = EditTextValidation.passwordEt(password)
            }


        }
        view.nav_to_register.setOnClickListener {
            view.findNavController().navigate(R.id.action_login_to_registerScreen)
        }

        return view
    }

    override fun onLoading(view: View) {
        view.login_btn.text = null
        view.progress_circular.visibility = View.VISIBLE
    }

    override fun onSuccess(view: View, authResponse: AuthResponse) {
        Components.setToken(requireContext(), authResponse.data.token)
        startActivity(Intent(requireActivity(), ProductActivity::class.java))
    }

    override fun onLoadingDone(view: View) {
        view.login_btn.text = "LOGIN"
        view.progress_circular.visibility = View.GONE
    }

    override fun onWrongInput(view: View, authResponse: AuthResponse) {
        Components.makeToast(requireActivity(), authResponse.message)
        onLoadingDone(view)
    }


}