package com.example.myecommarce.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

object EditTextValidation {
    fun emailEt(text:String?):String?{
        if(text!=null){
            if (text.contains("@")){
                return null
            }else{
                return "please enter an valid email"
            }
        }else{
            return "Please enter email"
        }
    }
    fun passwordEt(text:String?):String?{
        if(text!=null){
            if (text.length>=6){
                return null
            }else{
                return "please enter the password"
            }
        }else{
            return "Please enter the password"
        }
    }
    fun usernameEt(text:String?):String?{
        if(text!=null){
            if (text.length>=6){
                return null
            }else{
                return "please enter the username"
            }
        }else{
            return "Please enter the username"
        }
    }
    fun phoneEt(text:String?):String?{
        if(text!=null){
            if (text.length>=11){
                return null
            }else{
                return "please enter an phone"
            }
        }else{
            return "Please enter the phone"
        }
    }
}