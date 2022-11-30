package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.Setting
import com.bemo.client.databinding.ListSettingBinding

class SettingRecyclerAdapter(data: ArrayList<Setting>) :
    RecyclerView.Adapter<SettingRecyclerAdapter.SettingViewHolder>() {
    private val mData: ArrayList<Setting>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        context = parent.context
        return SettingViewHolder(ListSettingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        val item: Setting = mData[position]
        holder.mBinding.txtSetting.text = item.name
        holder.mBinding.root.setOnClickListener {
            context.startActivity(item.intent)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class SettingViewHolder internal constructor(val mBinding: ListSettingBinding) :
        RecyclerView.ViewHolder(mBinding.root)
}