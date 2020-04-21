/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com>
 * https://dvnlabs.xyz All right reserved
 * My Portfolio is Personal application that show portfolio for Davin Alfarizky Putra Basudewa
 */

package com.davin.davin_myportfolio.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.davin.davin_myportfolio.R
import com.davin.davin_myportfolio.model.SkillsModel
import kotlinx.android.synthetic.main.list_skills.view.*


class SkillsListAdapter(var context: Context, model: ArrayList<SkillsModel>) :
    RecyclerView.Adapter<SkillsListAdapter.SkillsListViewHolder>() {
    var models = model


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_skills, parent, false)
        return SkillsListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: SkillsListViewHolder, position: Int) {
        val dats = models[position]
        holder.name.text = dats.name
        holder.cert.text = dats.certification
    }

    inner class SkillsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.skillsName
        val cert = itemView.skillsCertification
    }
}