package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.Info
import com.bemo.client.databinding.ListTextBinding
import com.bemo.client.dialog.NoticeDialog

class NoticeRecyclerAdapter(data: ArrayList<Info>) :
    RecyclerView.Adapter<CustomViewHolder>() {
    private val mData: ArrayList<Info>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        context = parent.context
        return CustomViewHolder(ListTextBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item: Info = mData[position]
        (holder.mBinding as ListTextBinding).apply {
            text.text = item.title
            root.setOnClickListener {
                NoticeDialog(context, item).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}