package com.expostore.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.expostore.R
import com.expostore.api.pojo.getproduct.ProductImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tender_create_image_item.view.*

class SmallImageRecyclerViewAdapter(private var images: ArrayList<ProductImage>) : RecyclerView.Adapter<SmallImageRecyclerViewAdapter.SmallImageImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallImageImageViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.tender_create_image_item, parent, false)
        return SmallImageImageViewHolder(v)
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int = position

    override fun getItemCount(): Int = images.size

    inner class SmallImageImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.tender_image
    }

    override fun onBindViewHolder(holder: SmallImageImageViewHolder, position: Int) {
        val image = images[position]
        if (image.file != null) Picasso.get().load(image.file).into(holder.imageView)
    }
}