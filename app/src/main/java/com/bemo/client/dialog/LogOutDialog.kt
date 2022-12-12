package com.bemo.client.dialog

import android.content.Context
import android.view.LayoutInflater
import com.bemo.client.InfoIntent
import com.bemo.client.databinding.DialLogOutBinding

class LogOutDialog(context: Context, item: InfoIntent): CustomDialog(context) {

    init {
        mBinding = DialLogOutBinding.inflate(LayoutInflater.from(context)).apply {
            txtLogOutTitle.text = item.name

            btnNo.setOnClickListener {
                dismiss()
            }

            btnYes.setOnClickListener {
                context.startActivity(item.intent)
                // TODO: sqlite 회원 정보 삭제
                dismiss()
            }
        }

        setSize(width = (context.resources.displayMetrics.widthPixels * 0.8).toInt(),
            height = (context.resources.displayMetrics.heightPixels * 0.25).toInt())
    }
}