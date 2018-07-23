package com.example.mf.satwarasamaj.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
        homeModelList.add(HomeModel("History", R.drawable.ic_import_contacts))
        homeModelList.add(HomeModel("Greetings", R.drawable.ic_drafts))
        homeModelList.add(HomeModel("Vision & Mission", R.drawable.ic_track_changes))
        homeModelList.add(HomeModel("Directory", R.drawable.ic_import_contacts))
        homeModelList.add(HomeModel("Business Directory", R.drawable.ic_work))
        homeModelList.add(HomeModel("Article", R.drawable.ic_assignment))
        homeModelList.add(HomeModel("Career Guidance", R.drawable.ic_school))
        homeModelList.add(HomeModel("Job", R.drawable.ic_business_center))
        homeModelList.add(HomeModel("News", R.drawable.ic_local_library))
        homeModelList.add(HomeModel("Death News", R.drawable.ic_import_contacts))
        homeModelList.add(HomeModel("Advertisement", R.drawable.ic_library_books))
        homeModelList.add(HomeModel("Contact Us", R.drawable.ic_phone_in_talk))
        homeModelList.add(HomeModel("Managing Team", R.drawable.ic_people))
        homeModelList.add(HomeModel("Download", R.drawable.ic_cloud_download))
        homeModelList.add(HomeModel("Donate Now", R.drawable.ic_monetization))
        homeModelList.add(HomeModel("Help", R.drawable.ic_pan_tool))
        homeModelList.add(HomeModel("Biodata", R.drawable.ic_description))
        homeModelList.add(HomeModel("Logout", R.drawable.ic_power_settings_new))

        dashBoardRecyclerview.setHasFixedSize(true)
        dashBoardRecyclerview.layoutManager = GridLayoutManager(context, 3)
        dashBoardRecyclerview.adapter = HomeAdapter(homeModelList, this)
    }
}
