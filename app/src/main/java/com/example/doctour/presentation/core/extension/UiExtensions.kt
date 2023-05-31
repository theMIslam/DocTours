package com.example.doctour.core.extension

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun View.glide(url:String){
    Glide.with(this).load(url).centerCrop().into(this as ImageView)
}