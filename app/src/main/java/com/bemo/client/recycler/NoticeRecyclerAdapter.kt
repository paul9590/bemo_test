package com.bemo.client.recycler

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.Info
import com.bemo.client.databinding.DialNoticeBinding
import com.bemo.client.databinding.ListTextBinding

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
            showNoticeDial(item)
        }
    }

    private fun showNoticeDial(item: Info) {
        val dial = Dialog(context)
        dial.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dial.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val mBinding = DialNoticeBinding.inflate(LayoutInflater.from(context))
        dial.setContentView(mBinding.root)
        dial.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        mBinding.txtNoticeTitle.text = item.title
        mBinding.txtNoticeBody.text = item.body
        mBinding.imbBack.setOnClickListener {
            dial.dismiss()
        }
        dial.show()
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class NoticeViewHolder internal constructor(val mBinding: ListTextBinding) :
        RecyclerView.ViewHolder(mBinding.root)
}