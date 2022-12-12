package com.bemo.client.dialog

import android.content.Context
import android.view.LayoutInflater
import com.bemo.client.InfoIntent
import com.bemo.client.databinding.DialDeleteBinding

class DeleteDialog(context: Context, item: InfoIntent): CustomDialog(context) {

    init {
        mBinding = DialDeleteBinding.inflate(LayoutInflater.from(context)).apply {
            txtDeleteTitle.text = item.name

            btnYes.setOnClickListener {
                context.startActivity(item.intent)
                // TODO: 회원 탈퇴 API 호출
                dismiss()
            }

            btnNo.setOnClickListener {
                dismiss()
            }
        }
        setSize(width = (context.resources.displayMetrics.widthPixels * 0.8).toInt(),
            height = (context.resources.displayMetrics.heightPixels * 0.3).toInt())
    }
}