package com.example.mf.satwarasamaj.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.mf.satwarasamaj.R
import com.example.mf.satwarasamaj.inflate
import com.example.mf.satwarasamaj.model.City
import kotlinx.android.synthetic.main.city_layout.view.*

class CitiesAdapter(val citiesList: List<City>) : RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        return CitiesViewHolder(parent.inflate(R.layout.city_layout, false))
    }

    override fun getItemCount() = citiesList.size

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        holder.bindView(citiesList[position])
    }

    inner class CitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view = itemView
        fun bindView(city: City) {
            view.cityName.text = city.name
        }
    }
}