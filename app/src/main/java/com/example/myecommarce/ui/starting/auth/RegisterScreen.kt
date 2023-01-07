package com.example.myecommarce.ui.starting.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.myecommarce.R
import com.example.myecommarce.data.models.Auth.AuthResponse
import com.example.myecommarce.ui.main.ProductActivity
import com.example.myecommarce.utils.Components
import com.example.myecommarce.utils.EditTextValidation
import kotlinx.android.synthetic.main.activity_starting.view.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_register_screen.view.*

class RegisterScreen : Fragment(),AuthValidation {
    private var viewModel: AuthViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view  = inflater.inflate(R.layout.fragment_register_screen, container, false)
        view.toolbar.setNavigationOnClickListener {
            view.findNavController().navigate(R.id.action_registerScreen_to_login)
        }
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


        view.register_btn.setOnClickListener {

            val email = view.Register_email_et.text.toString()
            val password = view.Register_Password_et.text.toString()
            val username = view.Register_username_et.text.toString()
            val phone = view.Register_Phone_et.text.toString()

            if (EditTextValidation.emailEt(email) == null
                && EditTextValidation.passwordEt(password) == null
                && EditTextValidation.usernameEt(username) == null
                && EditTextValidation.phoneEt(phone) == null

            ) {
                onLoading(view)
               viewModel!!.register(username, phone , email , password , "")
            } else {
                view.Register_email_et.error = EditTextValidation.emailEt(email)
                view.Register_Password_et.error = EditTextValidation.passwordEt(password)
                view.Register_Phone_et.error = EditTextValidation.phoneEt(phone)
                view.Register_username_et.error = EditTextValidation.usernameEt(username)
            }

        }



        return view
    }

    override fun onLoading(view: View) {
        view.register_btn.text = null
        view.Register_progress_circular.visibility = View.VISIBLE
    }

    override fun onSuccess(view: View, authResponse: AuthResponse) {
        Components.setToken(requireContext(), authResponse.data.token)
        startActivity(Intent(requireActivity(), ProductActivity::class.java))
    }

    override fun onLoadingDone(view: View) {
        view.register_btn.text = "LOGIN"
        view.Register_progress_circular.visibility = View.GONE
    }

    override fun onWrongInput(view: View, authResponse: AuthResponse) {
        Components.makeToast(requireActivity(), authResponse.message)
        onLoadingDone(view)
    }

}