package com.bemo.client.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import com.bemo.client.InfoIntent
import com.bemo.client.databinding.DialDeleteBinding

class DeleteDialog(val context: Context) {
    private val dial = Dialog(context)
    private val mBinding: DialDeleteBinding = DialDeleteBinding.inflate(LayoutInflater.from(context))

    constructor(context: Context, item: InfoIntent) : this(context) {
        mBinding.txtDeleteTitle.text = item.name

        mBinding.btnNo.setOnClickListener {
            dial.dismiss()
        }

        mBinding.btnYes.setOnClickListener {
            context.startActivity(item.intent)
            dial.dismiss()
        }
    }

    fun show() {
        initDial()
        dial.show()
    }

    private fun initDial() {
        dial.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dial.setContentView(mBinding.root)
        setSize()
    }

    private fun setSize() {
        val x = (context.resources.displayMetrics.widthPixels * 0.8).toInt()
        val y = (context.resources.displayMetrics.heightPixels * 0.3).toInt()

        dial.window?.setLayout(x, y)

        dial.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}