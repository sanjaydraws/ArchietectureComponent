package com.example.architecturecomponent.models

import android.content.Context
import android.view.View
import android.widget.Toast

data class User (
    val profileName:String? = null ,
    val profileImage:String? =null,
    val age:Int? = null
        ){

    fun onProfileClick(view: View):String{
        return "$profileName age =$age"
    }
}