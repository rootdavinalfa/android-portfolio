/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com>
 * https://dvnlabs.xyz All right reserved
 * My Portfolio is Personal application that show portfolio for Davin Alfarizky Putra Basudewa
 */

package com.davin.davin_myportfolio.base

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseActivity : AppCompatActivity() {
    private var mActivity: AppCompatActivity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
    }

    protected open fun setupFragment(fragment: Fragment?, layout: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(layout, fragment!!)
            .commit()
    }

    protected open fun stackedFragment(fragment: Fragment?, layout: Int, tags: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(layout, fragment!!)
            .addToBackStack(null)
            .commit()
    }

    /**
     * Change status bar color by using following parameter
     *
     * [activity] Fill with requester Activity eg:MainActivity or using 'this'
     *
     * [color] Fill with ID
     *
     * [iconLight] Statement using light icon or not
     *
     * */
    protected open fun changeStatusBar(activity: Activity, color: Int, iconLight: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var flags = window.decorView.systemUiVisibility
            if (iconLight) {
                flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            window.decorView.systemUiVisibility = flags
            activity.window.statusBarColor = getColor(color)
        }
    }
}