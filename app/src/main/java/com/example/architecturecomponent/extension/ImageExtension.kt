package com.example.architecturecomponent.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.architecturecomponent.R



// use kotlin kapt plugin to apply data binding
@BindingAdapter("loadImage")
fun ImageView.loadImage(image: Any?){
    image?.let {
        Glide.with(this).load(image).centerCrop().into(this)
    }
}

