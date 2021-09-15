package com.example.architecturecomponent

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.architecturecomponent.models.User

class MainViewModel (application: Application) : AndroidViewModel(application) {

    private val _user = MutableLiveData<User>()
    val user : LiveData<User> = _user

    fun getUser(){
        val user = User("Justin Bieber", "https://i.stack.imgur.com/KprNa.jpg?s=64&g=1",23)
//        val user = User(null, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRSqoSEuV0lmNrEVLwJ6q75DaOWQjorN0b2G_BLJr4OScCX0YSZ",34)

        _user.value = user
    }

}