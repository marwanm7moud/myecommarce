package com.example.myecommarce.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myecommarce.R
import com.example.myecommarce.data.models.main.Categories.Category
import com.example.myecommarce.utils.Components
import kotlinx.android.synthetic.main.banner.view.*
import kotlinx.android.synthetic.main.homecategory.view.*
import java.lang.System.load

class CategoryAdapter(val list: List<Category>,val onClickListener: OnClickListener) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.homecategory , parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(list[position].image).into(holder.itemView.category_Image)
        holder.itemView.category_Title.text = list[position].name
        holder.itemView.setOnClickListener {
            onClickListener.onClick(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }




}
class OnClickListener(val clickListener: (category: Category) -> Unit) {
    fun onClick(category: Category) = clickListener(category)
}