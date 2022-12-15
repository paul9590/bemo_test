package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.HomeCategory
import com.bemo.client.databinding.ListCategoryBinding

class CategoryRecyclerAdapter(data: ArrayList<HomeCategory>) :
    RecyclerView.Adapter<CustomViewHolder>() {
    private val mData: ArrayList<HomeCategory>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        context = parent.context

        return CustomViewHolder(ListCategoryBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item: HomeCategory = mData[position]
        val mBinding = holder.mBinding
        (mBinding as ListCategoryBinding).apply {
            txtCategory.text = item.txt
            imgCategory.setImageResource(item.img)

            imgCategory.setOnClickListener {
                // TODO: 카테고리 클릭 시
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

}