package com.davin.davin_myportfolio.ui.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.davin.davin_myportfolio.R
import com.davin.davin_myportfolio.model.WorkModel
import kotlinx.android.synthetic.main.list_works.view.*


class WorksListAdapter(var context: Context, model: ArrayList<WorkModel>) :
    RecyclerView.Adapter<WorksListAdapter.WorksListViewHolder>() {
    var models = model


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorksListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_works, parent, false)
        return WorksListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WorksListViewHolder, position: Int) {
        val dats = models[position]
        holder.company.text = dats.company
        holder.extra.text = "${dats.status}- ${dats.duration}"
        holder.years.text = dats.years
        holder.role.text = dats.role
    }

    inner class WorksListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val company = itemView.worksCompany
        val extra = itemView.worksExtra
        val years = itemView.worksYears
        val role = itemView.worksRole
    }
}