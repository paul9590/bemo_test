package com.bemo.client.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.HomeCategory
import com.bemo.client.R

class CategoryRecyclerAdapter(data: ArrayList<HomeCategory>) :
    RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>() {
    private val mData: ArrayList<HomeCategory>

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_category, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item: HomeCategory = mData[position]
        holder.txtCategory.text = item.txt
        holder.imgCategory.setImageResource(item.img)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class CategoryViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imgCategory: ImageView
        var txtCategory: TextView

        init {
            imgCategory = itemView.findViewById(R.id.imgCategory)
            txtCategory = itemView.findViewById(R.id.txtCategory)
            imgCategory.setOnClickListener {
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    val item = mData[pos]
                    // TODO: 카테고리 클릭 시
                }
            }
        }
    }
}