package com.example.mf.satwarasamaj

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun ImageView.loadImage(url : Int){
    Glide.with(context)
            .load(url)
            .into(this)
}

fun Context.showMessage(message : String){
    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
}


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
