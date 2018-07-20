package com.example.mf.satwarasamaj.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.example.mf.satwarasamaj.R
import com.example.mf.satwarasamaj.adapters.HomeAdapter
import com.example.mf.satwarasamaj.model.HomeModel
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(), HomeAdapter.HomeAdapterListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val homeModelList = mutableListOf<HomeModel>()
        //homeModelList.add()

        dashBoardRecyclerview.setHasFixedSize(true)
        dashBoardRecyclerview.layoutManager = GridLayoutManager(context, 3)
        dashBoardRecyclerview.adapter = HomeAdapter(homeModelList,this)
    }


}
