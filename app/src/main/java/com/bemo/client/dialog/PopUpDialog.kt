package com.bemo.client.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.Window
import com.bemo.client.databinding.DialPopUpAdBinding

class PopUpDialog(val context: Context) {
    private val dial = Dialog(context)
    private val mBinding: DialPopUpAdBinding = DialPopUpAdBinding.inflate(LayoutInflater.from(context))

    constructor(context: Context, item: Drawable) : this(context) {
        mBinding.imgAD.background = item
    }

    init {
        mBinding.txtExit.setOnClickListener {
            dial.dismiss()
        }

        mBinding.btnExit.setOnClickListener {
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
        val y = (context.resources.displayMetrics.heightPixels * 0.6).toInt()

        dial.window?.setLayout(x, y)
        dial.setCancelable(false)
        dial.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}