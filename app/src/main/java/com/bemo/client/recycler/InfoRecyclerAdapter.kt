package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.InfoIntent
import com.bemo.client.databinding.ListTextBinding

class InfoRecyclerAdapter(data: ArrayList<InfoIntent>) :
    RecyclerView.Adapter<InfoRecyclerAdapter.InfoViewHolder>() {
    private val mData: ArrayList<InfoIntent>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        context = parent.context
        return InfoViewHolder(ListTextBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val item: InfoIntent = mData[position]
        holder.mBinding.text.text = item.name
        holder.mBinding.root.setOnClickListener {
            context.startActivity(item.intent)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class InfoViewHolder internal constructor(val mBinding: ListTextBinding) :
        RecyclerView.ViewHolder(mBinding.root)
}