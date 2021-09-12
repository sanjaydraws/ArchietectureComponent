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


        binding?.response?.setOnClickListener {
            mViewModel.getUser()
            binding?.group1?.isVisible  = true
            binding?.group2?.isVisible = false
        }
        binding?.response2?.setOnClickListener {
            binding?.group1?.isVisible  = false
            binding?.group2?.isVisible = true
            binding?.list = list1
            binding?.map = map
            binding?.key = "key1"
        }

        binding?.profilename?.setOnClickListener {

        }



        mViewModel.user.observe(this, Observer {
            it?:return@Observer
            binding?.model = it
            binding?.profileImage?.let { it1 ->
                Glide
                    .with(this)
                    .load(it.profileImage)
                    .centerCrop()
                    .into(it1)
            }
        })





    }
}