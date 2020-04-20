package com.davin.davin_myportfolio.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.davin.davin_myportfolio.R
import com.davin.davin_myportfolio.model.EducationModel
import com.davin.davin_myportfolio.utils.AssetParser
import kotlinx.android.synthetic.main.list_education.view.*


class EducationListAdapter(var context: Context, model: ArrayList<EducationModel>) :
    RecyclerView.Adapter<EducationListAdapter.EducationListViewHolder>() {
    var models = model


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_education, parent, false)
        return EducationListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: EducationListViewHolder, position: Int) {
        val dats = models[position]
        Glide.with(context)
            .load(AssetParser().getImageAsset(context, dats.img))
            .into(holder.img)
        holder.year.text = dats.years
        holder.major.text = dats.majors
        holder.institute.text = dats.institute
        holder.level.text = dats.level
    }

    inner class EducationListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val year = itemView.eduYears
        val img = itemView.eduImg
        val major = itemView.eduMajors
        val institute = itemView.eduInstitute
        val level = itemView.eduLevel
    }
}