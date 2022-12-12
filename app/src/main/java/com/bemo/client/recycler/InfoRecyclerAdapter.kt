package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.INTENT_LOGOUT
import com.bemo.client.INTENT_DELETE
import com.bemo.client.InfoIntent
import com.bemo.client.databinding.ListTextBinding
import com.bemo.client.dialog.DeleteDialog
import com.bemo.client.dialog.LogOutDialog

class InfoRecyclerAdapter(data: ArrayList<InfoIntent>) :
    RecyclerView.Adapter<CustomViewHolder>() {
    private val mData: ArrayList<InfoIntent>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        context = parent.context
        return CustomViewHolder(ListTextBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item: InfoIntent = mData[position]
        (holder.mBinding as ListTextBinding).apply {
            text.text = item.name
            root.setOnClickListener {
                when(item.flag) {
                    INTENT_LOGOUT -> {
                        LogOutDialog(context, item).show()
                    }

                    INTENT_DELETE -> {
                        DeleteDialog(context, item).show()
                    }

                    else -> {
                        context.startActivity(item.intent)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}