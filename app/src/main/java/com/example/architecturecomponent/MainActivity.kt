package com.example.architecturecomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.architecturecomponent.databinding.ActivityMainBinding
import com.example.architecturecomponent.models.User
import com.github.ybq.android.spinkit.style.ChasingDots
import com.github.ybq.android.spinkit.style.Circle


class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding? =   null
    private val mViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // inflate() create an instance of binding class
        binding?.apply {
            // call getRoot() to get the reference of root view
            // pass to  setContentView() to see active view on screen
            setContentView(this.root)
        }



        val list1 = listOf<String>("Hello", "Hi", "Hey")
        val map = mapOf( "key1" to "k1", "Key2" to "k2")

        val circle = Circle()
        binding?.chasingDots?.setIndeterminateDrawable(circle)
        binding?.loader =true


        binding?.response?.setOnClickListener {
            mViewModel.getUser()
            binding?.group1?.isVisible  = true
            binding?.group2?.isVisible = false
            binding?.loader = false

        }
        binding?.response2?.setOnClickListener {
            binding?.group1?.isVisible  = false
            binding?.group2?.isVisible = true
            binding?.list = list1
            binding?.map = map
            binding?.key = "key1"
//            binding.user  = User("Jb",".....url" ,34)
        }

        binding?.profilename?.setOnClickListener {

        }



        mViewModel.user.observe(this, Observer {
            it?:return@Observer
            binding?.model = it
        })





    }
}