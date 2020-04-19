package com.davin.davin_myportfolio

import android.os.Bundle
import com.davin.davin_myportfolio.Base.BaseActivity
import com.davin.davin_myportfolio.ui.fragment.HomeFragment
import com.davin.davin_myportfolio.ui.fragment.ProjectFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : BaseActivity() {
    var bottomNav: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeStatusBar(this, R.color.white, true)

        setContentView(R.layout.main_activity)
        bottomNav = findViewById(R.id.bottomNavigationView)

        //Setup fragment then attaching it to bottomnav
        setupFragment(HomeFragment(), R.id.mainFrame)
        bottomNav!!.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navHome -> {
                    setupFragment(HomeFragment(), R.id.mainFrame)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navProject -> {
                    setupFragment(ProjectFragment(), R.id.mainFrame)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    setupFragment(HomeFragment(), R.id.mainFrame)
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }

    }
}