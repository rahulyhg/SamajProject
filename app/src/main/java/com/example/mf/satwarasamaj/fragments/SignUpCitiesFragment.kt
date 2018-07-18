package com.example.mf.satwarasamaj.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mf.satwarasamaj.R
import com.example.mf.satwarasamaj.adapters.CitiesAdapter
import com.example.mf.satwarasamaj.model.City
import kotlinx.android.synthetic.main.fragment_sign_up_cities.*

class SignUpCitiesFragment : Fragment() {

    var mListener: SignUpCitiesFragmentListener? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_up_cities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mListener?.callGetCitiesApi()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is SignUpCitiesFragmentListener) {
            mListener = context;
        } else {
            throw RuntimeException(context.toString() + " must implement SignUpCitiesFragmentListener")
        }
    }

    fun setCitiesRecyclerview(citiesList: List<City>?) {
        if (citiesList != null && citiesList.isNotEmpty()) {
            citiesRecyclerview.setHasFixedSize(true)
            citiesRecyclerview.layoutManager = LinearLayoutManager(context)
            citiesRecyclerview.adapter = CitiesAdapter(citiesList)
            citiesRecyclerview.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        }
    }

    interface SignUpCitiesFragmentListener {
        fun callGetCitiesApi()
    }


}
