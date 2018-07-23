package com.example.mf.satwarasamaj.activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDialogFragment
import android.support.v7.widget.Toolbar
import android.text.SpannableStringBuilder
import android.view.MenuItem
import com.example.mf.satwarasamaj.R
import com.example.mf.satwarasamaj.classes.BottomNavigationViewHelper
import com.example.mf.satwarasamaj.fragments.DashboardFragment
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar as Toolbar)
        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        BottomNavigationViewHelper.removeShiftingMode(bottomNavigationView)
        navigationView.setCheckedItem(R.id.action_share)
        navigationView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_share -> {
                    item.setChecked(true)
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_contact -> {
                    item.setChecked(true)
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_rate -> {
                    item.setChecked(true)
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_social_circle -> {
                    item.setChecked(true)
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_contributor -> {
                    item.setChecked(true)
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_app_developers -> {
                    item.setChecked(true)
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_support -> {
                    item.setChecked(true)
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_app_info -> {
                    item.setChecked(true)
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_setting -> {
                    item.setChecked(true)
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_change_password -> {
                    item.setChecked(true)
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_logout -> {
                    item.setChecked(true)
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })


        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_bottom_home -> {
                    setFragment(DashboardFragment())
                }
                R.id.action_bottom_dashboard -> {
                }
                R.id.action_bottom_events -> {
                }
                R.id.action_bottom_library -> {
                }
            }
            true
        }
        bottomNavigationView.setSelectedItemId(R.id.action_bottom_home)
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }
}
