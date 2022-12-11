package com.bemo.client.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import com.bemo.client.InfoIntent
import com.bemo.client.databinding.DialLogOutBinding

class LogOutDialog(val context: Context) {
    private val dial = Dialog(context)
    private val mBinding: DialLogOutBinding = DialLogOutBinding.inflate(LayoutInflater.from(context))

    constructor(context: Context, item: InfoIntent) : this(context) {
        mBinding.txtLogOutTitle.text = item.name

        mBinding.btnNo.setOnClickListener {
            dial.dismiss()
        }

        mBinding.btnYes.setOnClickListener {
            context.startActivity(item.intent)
            // TODO: sqlite 회원 정보 삭제
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
        val y = (context.resources.displayMetrics.heightPixels * 0.25).toInt()

        dial.window?.setLayout(x, y)
        dial.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}