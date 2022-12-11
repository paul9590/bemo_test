package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.Info
import com.bemo.client.databinding.ListTextBinding
import com.bemo.client.dialog.NoticeDialog

class NoticeRecyclerAdapter(data: ArrayList<Info>) :
    RecyclerView.Adapter<NoticeRecyclerAdapter.NoticeViewHolder>() {
    private val mData: ArrayList<Info>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        context = parent.context
        return NoticeViewHolder(ListTextBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        val item: Info = mData[position]
        holder.mBinding.text.text = item.title
        holder.mBinding.root.setOnClickListener {
            NoticeDialog(context, item).show()
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class NoticeViewHolder internal constructor(val mBinding: ListTextBinding) :
        RecyclerView.ViewHolder(mBinding.root)
}