package com.example.mf.satwarasamaj.activities

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.mf.satwarasamaj.R
import com.example.mf.satwarasamaj.api.RetroClient
import com.example.mf.satwarasamaj.fragments.SignUpCitiesFragment
import com.example.mf.satwarasamaj.fragments.SignUpNameFragment
import com.example.mf.satwarasamaj.fragments.SignUpPasswordFragment
import com.example.mf.satwarasamaj.model.City
import com.example.mf.satwarasamaj.showMessage
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity(), SignUpNameFragment.SignUpNameFragmentListener,
        SignUpCitiesFragment.SignUpCitiesFragmentListener, SignUpPasswordFragment.SignUpPasswordFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setFragment(SignUpNameFragment(), false)
    }

    fun setFragment(fragment: Fragment, animate: Boolean) {

        val fTransaction = supportFragmentManager.beginTransaction()
        if (animate) {
            fTransaction.setCustomAnimations(R.anim.enter_from_right,
                    R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
        }
        fTransaction.replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun onNextButtonClicked() {
        setFragment(SignUpCitiesFragment(), true)
    }


    override fun callGetCitiesApi() {
        RetroClient().getRetroClient()
                .doGetCitiesApiCall()
                .enqueue(object : Callback<List<City>> {
                    override fun onFailure(call: Call<List<City>>?, t: Throwable) {
                        showMessage("Something went wrong")
                        //showMessage(t.localizedMessage)
                    }

                    override fun onResponse(call: Call<List<City>>?, response: Response<List<City>>) {
                        if (response.isSuccessful) {
                            if (getCurrentFragment() is SignUpCitiesFragment) {
                                (getCurrentFragment() as SignUpCitiesFragment).setCitiesRecyclerview(response.body())
                            }
                        } else {
                            showMessage("Unable to get cities")
                        }
                    }
                })
    }

    fun getCurrentFragment() = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

    override fun onCitySelected(city: City) {
        setFragment(SignUpPasswordFragment(), true)
    }

    override fun onFinishButtonClicked() {
        val homeIntent = Intent(this, HomeActivity::class.java)
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(homeIntent)
        finish()
    }
}
