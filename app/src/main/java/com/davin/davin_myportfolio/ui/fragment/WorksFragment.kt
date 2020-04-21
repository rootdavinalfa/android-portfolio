/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com>
 * https://dvnlabs.xyz All right reserved
 * My Portfolio is Personal application that show portfolio for Davin Alfarizky Putra Basudewa
 */

package com.davin.davin_myportfolio.ui.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.davin.davin_myportfolio.MainActivity
import com.davin.davin_myportfolio.R
import com.davin.davin_myportfolio.base.BaseFragment
import com.davin.davin_myportfolio.model.WorkModel
import com.davin.davin_myportfolio.ui.list.WorksListAdapter
import com.davin.davin_myportfolio.utils.AssetParser
import com.google.android.material.card.MaterialCardView
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.ColorFilterTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.works_fragment.view.*
import org.json.JSONArray
import org.json.JSONException

class WorksFragment : BaseFragment() {
    var header: MaterialCardView? = null
    var back: ImageView? = null
    var rvWorks: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.works_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        header = view.workHeader
        back = view.workBackIcon
        rvWorks = view.rvWork


        //Glide attach image
        val multi = MultiTransformation(
            ColorFilterTransformation(R.color.blacktrans),
            RoundedCornersTransformation(10, 0),
            BlurTransformation(5, 3)
        )
        Glide.with(this)
            .load(AssetParser().getImageAsset(context!!, "image/header/works.jpeg"))
            .transform(multi)
            .transition(
                DrawableTransitionOptions()
                    .crossFade()
            ).apply(
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL).override(424, 600)
            ).into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    header!!.background = resource
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    //Nothing
                }
            })

        back!!.setOnClickListener {
            (context as MainActivity).onBackPressed()
        }

        getWorkExp()
    }

    private fun getWorkExp() {
        val strings = AssetParser().getJsonAssets(context!!, "docs/worke.json")
        val data = ArrayList<WorkModel>()
        try {
            val arrays = JSONArray(strings)
            for (i in 0 until arrays.length()) {
                val x = arrays.getJSONObject(i)
                val company = x.getString("company")
                val dur = x.getString("duration")
                val role = x.getString("role")
                val status = x.getString("status")
                val years = x.getString("years")
                data.add(WorkModel(company, dur, role, status, years))
            }
            rvWorks!!.layoutManager = LinearLayoutManager(context!!)
            rvWorks!!.adapter = WorksListAdapter(context!!, data)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}