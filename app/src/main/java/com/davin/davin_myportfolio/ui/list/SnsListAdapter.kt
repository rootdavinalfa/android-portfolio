/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com>
 * https://dvnlabs.xyz All right reserved
 * My Portfolio is Personal application that show portfolio for Davin Alfarizky Putra Basudewa
 */

package com.davin.davin_myportfolio.ui.list

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.davin.davin_myportfolio.R
import com.davin.davin_myportfolio.model.SnsModel
import com.davin.davin_myportfolio.utils.AssetParser
import kotlinx.android.synthetic.main.list_sns.view.*


class SnsListAdapter(var context: Context, model: ArrayList<SnsModel>) :
    RecyclerView.Adapter<SnsListAdapter.SnsListViewHolder>() {
    var models = model


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_sns, parent, false)
        return SnsListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: SnsListViewHolder, position: Int) {
        val dats = models[position]
        Glide.with(context)
            .load(AssetParser().getImageAsset(context, dats.img))
            .into(holder.img)
        holder.name.text = dats.name
        Glide.with(context)
            .load(AssetParser().getImageAsset(context, dats.img))
            .into(holder.img)
    }

    inner class SnsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val name = itemView.snsName
        val img = itemView.snsImg

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(models[adapterPosition].url))
            context.startActivity(intent)
        }

    }
}