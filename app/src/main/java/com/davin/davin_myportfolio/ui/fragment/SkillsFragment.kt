package com.davin.davin_myportfolio.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.davin.davin_myportfolio.Base.BaseFragment
import com.davin.davin_myportfolio.R

class SkillsFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.skills_fragment, container, false)
    }
}