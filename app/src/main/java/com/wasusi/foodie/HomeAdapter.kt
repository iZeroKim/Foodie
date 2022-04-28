package com.wasusi.foodie

import android.icu.number.NumberFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

internal class HomeAdapter(private var itemsList: List<Food>) :
    RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var foodName: TextView = view.findViewById(R.id.tvFoodName)
        var foodPrice: TextView = view.findViewById(R.id.tvPrice)
        var imageView: ImageView = view.findViewById(R.id.ivFoodImage)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_layout, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.foodName.text = itemsList[position].name
        holder.foodPrice.text = "Ksh. ${itemsList[position].price}"

        //Load image using Picasso
        Picasso.get().load(R.drawable.foodie).into(holder.imageView)

    }
    override fun getItemCount(): Int {
        return itemsList.size
    }
}