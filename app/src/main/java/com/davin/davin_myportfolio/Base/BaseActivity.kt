package com.davin.davin_myportfolio.Base

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

    /**
     * changeStatusBar
     * @param activity provide related activity
     * @param color provide id for color
     * @param iconLight using iconLight?
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