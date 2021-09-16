package com.example.architecturecomponent.extension

import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("android:paddingLeft")
fun setPaddingLeft(view: View, padding: Int) {
    view.setPadding(padding,
        view.paddingTop,
        view.paddingRight,
        view.paddingBottom
    )
}