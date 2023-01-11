package com.bemo.client.dialog

import android.app.ActionBar
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.viewbinding.ViewBinding

abstract class CustomDialog(val context: Context) {
    private val dial = Dialog(context)
    lateinit var mBinding: ViewBinding
    private var width = ActionBar.LayoutParams.MATCH_PARENT
    private var height = ActionBar.LayoutParams.MATCH_PARENT

    init {
        dial.requestWindowFeature(Window.FEATURE_NO_TITLE)
    }

    fun show() {
        initDial()
        dial.show()
    }

    private fun initDial() {
        dial.setContentView(mBinding.root)
        dial.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setSize(width, height)
        dial.window?.setLayout(width, height)
    }

    fun setSize(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

    fun dismiss() {
        dial.dismiss()
    }
}
