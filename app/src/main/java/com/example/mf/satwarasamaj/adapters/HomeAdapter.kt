package com.example.mf.satwarasamaj.adapters

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.example.mf.satwarasamaj.R
import com.example.mf.satwarasamaj.inflate
import com.example.mf.satwarasamaj.loadImage
import com.example.mf.satwarasamaj.model.HomeModel
import kotlinx.android.synthetic.main.home_recycler_layout.view.*

class HomeAdapter(val homeModelList: List<HomeModel>, val mListener: HomeAdapterListener) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(parent.inflate(R.layout.home_recycler_layout, false))
    }

    override fun getItemCount() = homeModelList.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindView(homeModelList[position])
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val view = itemView

        fun bindView(homeModel: HomeModel) {
            view.icon.loadImage(homeModel.Icon)
            view.nameText.text = homeModel.title
        }
    }

    interface HomeAdapterListener {

    }
}