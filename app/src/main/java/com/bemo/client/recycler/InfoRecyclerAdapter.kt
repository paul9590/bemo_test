package com.bemo.client.recycler

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.INTENT_LOGOUT
import com.bemo.client.INTENT_DELETE
import com.bemo.client.InfoIntent
import com.bemo.client.databinding.DialDeleteBinding
import com.bemo.client.databinding.DialLogOutBinding
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
            when(item.flag) {
                INTENT_LOGOUT -> {
                    logOutDial(item)
                }

                INTENT_DELETE -> {
                    deleteDial(item)
                }

                else -> {
                    context.startActivity(item.intent)
                }
            }
        }
    }

    private fun logOutDial(item: InfoIntent) {
        val dial = Dialog(context)
        val mBinding = DialLogOutBinding.inflate(LayoutInflater.from(context))
        dial.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dial.setContentView(mBinding.root)
        val x = (context.resources.displayMetrics.widthPixels * 0.8).toInt()
        val y = (context.resources.displayMetrics.heightPixels * 0.25).toInt()
        dial.window?.setLayout(x, y)
        dial.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dial.show()

        mBinding.txtLogOutTitle.text = item.name
        mBinding.btnNo.setOnClickListener {
            dial.dismiss()
        }
        mBinding.btnYes.setOnClickListener {
            context.startActivity(item.intent)
        }
    }

    private fun deleteDial(item: InfoIntent) {
        val dial = Dialog(context)
        val mBinding = DialDeleteBinding.inflate(LayoutInflater.from(context))
        dial.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dial.setContentView(mBinding.root)
        val x = (context.resources.displayMetrics.widthPixels * 0.8).toInt()
        val y = (context.resources.displayMetrics.heightPixels * 0.3).toInt()
        dial.window?.setLayout(x, y)
        dial.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dial.show()
        mBinding.txtDeleteTitle.text = item.name
        mBinding.btnNo.setOnClickListener {
            dial.dismiss()
        }
        mBinding.btnYes.setOnClickListener {
            context.startActivity(item.intent)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class InfoViewHolder internal constructor(val mBinding: ListTextBinding) :
        RecyclerView.ViewHolder(mBinding.root)
}