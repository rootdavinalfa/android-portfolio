/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com>
 * https://dvnlabs.xyz All right reserved
 * My Portfolio is Personal application that show portfolio for Davin Alfarizky Putra Basudewa
 */

package com.davin.davin_myportfolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.davin.davin_myportfolio.base.BaseActivity
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

    fun openFragment(fragment: Fragment, layout: Int, tags: String) {
        stackedFragment(fragment, layout, tags)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            super.onBackPressed()
        }
    }
}