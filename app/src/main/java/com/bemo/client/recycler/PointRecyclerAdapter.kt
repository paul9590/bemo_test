package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.PointInfo
import com.bemo.client.databinding.ListPointBinding

class PointRecyclerAdapter(data: ArrayList<PointInfo>) :
    RecyclerView.Adapter<CustomViewHolder>() {
    private val mData: ArrayList<PointInfo>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        context = parent.context
        return CustomViewHolder(ListPointBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item: PointInfo = mData[position]
        (holder.mBinding as ListPointBinding).apply {
            txtPointTitle.text = item.title
            txtPointBody.text = item.body
            imgPoint.setImageResource(item.img)
            btnPoint.setOnClickListener{
                // TODO: 포인트 상점 구매 신청 API 호출
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}