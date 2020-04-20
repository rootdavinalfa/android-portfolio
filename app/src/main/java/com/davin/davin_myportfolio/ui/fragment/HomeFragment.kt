package com.davin.davin_myportfolio.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.davin.davin_myportfolio.Base.BaseFragment
import com.davin.davin_myportfolio.MainActivity
import com.davin.davin_myportfolio.R
import com.davin.davin_myportfolio.utils.AssetParser
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.home_fragment.view.*

class HomeFragment : BaseFragment() {
    var image: ImageView? = null
    var eduView: MaterialCardView? = null
    var skillsView: MaterialCardView? = null
    var worksView: MaterialCardView? = null
    var snsView: MaterialCardView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.davinImage
        eduView = view.educationView
        skillsView = view.skillsView
        worksView = view.worksView
        snsView = view.snsView
        Glide.with(this)
            .load(AssetParser().getImageAsset(context!!, "image/davin.jpg"))
            .transform(CircleCrop())
            .transition(
                DrawableTransitionOptions()
                    .crossFade()
            ).apply(
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL).override(600, 600)
            ).into(image!!)
        clickInit()
    }

    private fun clickInit() {
        image!!.setOnClickListener {
            val popImage = ImagePopFragment()
            popImage.show(activity!!.supportFragmentManager, "POP")
        }
        eduView!!.setOnClickListener {
            (context!! as MainActivity).openFragment(EduFragment(), R.id.mainFrame, "EDU")
        }
        skillsView!!.setOnClickListener {
            (context!! as MainActivity).openFragment(SkillsFragment(), R.id.mainFrame, "SKILLS")
        }
        worksView!!.setOnClickListener {
            (context!! as MainActivity).openFragment(WorksFragment(), R.id.mainFrame, "WORKS")
        }
        snsView!!.setOnClickListener {
            (context!! as MainActivity).openFragment(SnsFragment(), R.id.mainFrame, "SNS")
        }
    }
}