package com.example.myecommarce.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myecommarce.R
import com.example.myecommarce.data.models.main.banner.BannersData
import kotlinx.android.synthetic.main.banner.view.*
import kotlinx.android.synthetic.main.homecategory.view.*

class BannersAdapter(val list:List<BannersData>) : RecyclerView.Adapter<BannersAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banner, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(list[position].image).into(holder.itemView.imageView)



    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}