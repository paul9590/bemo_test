package com.bemo.client.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import com.bemo.client.Info
import com.bemo.client.databinding.DialNoticeBinding

class NoticeDialog(val context: Context) {
    private val dial = Dialog(context)
    private val mBinding: DialNoticeBinding = DialNoticeBinding.inflate(LayoutInflater.from(context))

    constructor(context: Context, item: Info) : this(context) {
        mBinding.txtNoticeTitle.text = item.title
        mBinding.txtNoticeBody.text = item.body
    }

    init {
        mBinding.imbBack.setOnClickListener {
            dial.dismiss()
        }
    }

    fun show() {
        initDial()
        dial.show()
    }

    private fun initDial() {
        dial.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dial.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dial.setContentView(mBinding.root)
    }
}