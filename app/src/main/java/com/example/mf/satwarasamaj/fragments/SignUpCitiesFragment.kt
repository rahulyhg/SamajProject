package com.example.mf.satwarasamaj.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.mf.satwarasamaj.R
import com.example.mf.satwarasamaj.adapters.CitiesAdapter
import com.example.mf.satwarasamaj.model.City
import kotlinx.android.synthetic.main.fragment_sign_up_cities.*

class SignUpCitiesFragment : Fragment(), SearchView.OnQueryTextListener, CitiesAdapter.CitiesAdapterListener {

    override fun onQueryTextSubmit(query: String?) = false

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    var mListener: SignUpCitiesFragmentListener? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_up_cities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mListener?.callGetCitiesApi()

        val searchText = citySearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text) as TextView
        searchText.typeface = ResourcesCompat.getFont(view.context, R.font.poppins_regular)
        searchText.textSize = 14f
        citySearchView.setOnQueryTextListener(this)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is SignUpCitiesFragmentListener) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement SignUpCitiesFragmentListener")
        }
    }

    fun setCitiesRecyclerview(citiesList: List<City>?) {
        if (citiesList != null && citiesList.isNotEmpty()) {
            citiesRecyclerview.setHasFixedSize(true)
            citiesRecyclerview.layoutManager = LinearLayoutManager(context)
            citiesRecyclerview.adapter = CitiesAdapter(citiesList, this)
            citiesRecyclerview.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        }
    }

    override fun onCitySelected(city: City) {
        mListener?.onCitySelected(city)
    }

    interface SignUpCitiesFragmentListener {
        fun callGetCitiesApi()
        fun onCitySelected(city: City)
    }
}
