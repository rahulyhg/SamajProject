package com.example.mf.satwarasamaj.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.mf.satwarasamaj.R
import com.example.mf.satwarasamaj.fragments.SignUpNameFragment
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), SignUpNameFragment.SignUpNameFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setFragment(SignUpNameFragment())
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }

    override fun onNextButtonClicked() {
        super.onNextButtonClicked()
    }
}
