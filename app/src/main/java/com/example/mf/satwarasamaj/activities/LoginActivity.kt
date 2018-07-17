package com.example.mf.satwarasamaj.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mf.satwarasamaj.R
import com.example.mf.satwarasamaj.loadImage
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        samajLogo.loadImage(R.drawable.logo)
    }
}
