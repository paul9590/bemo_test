package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.PointInfo
import com.bemo.client.databinding.ListPointBinding

class PointRecyclerAdapter(data: ArrayList<PointInfo>) :
    RecyclerView.Adapter<PointRecyclerAdapter.PointViewHolder>() {
    private val mData: ArrayList<PointInfo>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointViewHolder {
        context = parent.context
        return PointViewHolder(ListPointBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PointViewHolder, position: Int) {
        val item: PointInfo = mData[position]
        holder.mBinding.txtPointTitle.text = item.title
        holder.mBinding.txtPointBody.text = item.body
        holder.mBinding.imgPoint.setImageResource(item.img)
        holder.mBinding.btnPoint.setOnClickListener{
            // 서버 연결
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class PointViewHolder internal constructor(val mBinding: ListPointBinding) :
        RecyclerView.ViewHolder(mBinding.root)
}