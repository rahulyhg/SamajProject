package com.example.mf.satwarasamaj

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url : Int){
    Glide.with(context)
            .load(url)
            .into(this)
}