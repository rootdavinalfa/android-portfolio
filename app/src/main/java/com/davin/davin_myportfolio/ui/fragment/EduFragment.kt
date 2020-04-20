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
import com.davin.davin_myportfolio.model.EducationModel
import com.davin.davin_myportfolio.ui.list.EducationListAdapter
import com.davin.davin_myportfolio.utils.AssetParser
import com.google.android.material.card.MaterialCardView
import jp.wasabeef.glide.transformations.ColorFilterTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.edu_fragment.view.*
import org.json.JSONArray
import org.json.JSONException


class EduFragment : Fragment() {
    var header: MaterialCardView? = null
    var back: ImageView? = null
    var rvEdu: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.edu_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        header = view.educationHeader
        back = view.eduBackIcon
        rvEdu = view.rvEducation
        //Glide attach image
        val multi = MultiTransformation(
            ColorFilterTransformation(R.color.blacktrans),
            RoundedCornersTransformation(10, 0)
        )
        Glide.with(this)
            .load(AssetParser().getImageAsset(context!!, "image/header/education.png"))
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

        getEducation()
    }

    private fun getEducation() {
        val strings = AssetParser().getJsonAssets(context!!, "docs/education.json")
        val data = ArrayList<EducationModel>()
        try {
            val arrays = JSONArray(strings)
            for (i in 0 until arrays.length()) {
                val x = arrays.getJSONObject(i)
                val inst = x.getString("institute")
                val lvl = x.getString("level")
                val majors = x.getString("majors")
                val years = x.getString("years")
                val img = x.getString("img")
                data.add(EducationModel(inst, lvl, majors, years, img))
            }
            rvEdu!!.layoutManager = LinearLayoutManager(context!!)
            rvEdu!!.adapter = EducationListAdapter(context!!, data)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }


}