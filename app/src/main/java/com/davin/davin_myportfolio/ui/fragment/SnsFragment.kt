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
import androidx.fragment.app.Fragment
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
import com.davin.davin_myportfolio.model.SnsModel
import com.davin.davin_myportfolio.ui.list.SnsListAdapter
import com.davin.davin_myportfolio.utils.AssetParser
import com.google.android.material.card.MaterialCardView
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.ColorFilterTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.sns_fragment.view.*
import org.json.JSONArray
import org.json.JSONException

class SnsFragment : Fragment() {
    var header: MaterialCardView? = null
    var back: ImageView? = null
    var rvSns: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sns_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        header = view.snsHeader
        back = view.snsBackIcon
        rvSns = view.rvSns


        //Glide attach image
        val multi = MultiTransformation(
            ColorFilterTransformation(R.color.blacktrans),
            RoundedCornersTransformation(10, 0),
            BlurTransformation(5, 3)
        )
        Glide.with(this)
            .load(AssetParser().getImageAsset(context!!, "image/header/sns.png"))
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
        getSns()
    }

    private fun getSns() {
        val strings = AssetParser().getJsonAssets(context!!, "docs/sns.json")
        val data = ArrayList<SnsModel>()
        try {
            val arrays = JSONArray(strings)
            for (i in 0 until arrays.length()) {
                val x = arrays.getJSONObject(i)
                val name = x.getString("name")
                val img = x.getString("img")
                val url = x.getString("url")
                data.add(SnsModel(name, url, img))
            }
            rvSns!!.layoutManager = LinearLayoutManager(context!!)
            rvSns!!.adapter = SnsListAdapter(context!!, data)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}