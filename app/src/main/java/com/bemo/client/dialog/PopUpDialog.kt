package com.bemo.client.dialog

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import com.bemo.client.databinding.DialPopUpAdBinding

class PopUpDialog(context: Context, item: Drawable): CustomDialog(context) {

    init {
        mBinding = DialPopUpAdBinding.inflate(LayoutInflater.from(context)).apply {
            imgAD.background = item
            txtExit.setOnClickListener {
                dismiss()
            }

            btnExit.setOnClickListener {
                dismiss()
            }
        }
        setSize(width = (context.resources.displayMetrics.widthPixels * 0.8).toInt(),
            height = (context.resources.displayMetrics.heightPixels * 0.6).toInt())
    }
}