package com.bemo.client.dialog

import android.content.Context
import android.view.LayoutInflater
import com.bemo.client.Info
import com.bemo.client.databinding.DialNoticeBinding

class NoticeDialog(context: Context, item: Info): CustomDialog(context) {

    init {
        mBinding = DialNoticeBinding.inflate(LayoutInflater.from(context)).apply {
            txtNoticeTitle.text = item.title
            txtNoticeBody.text = item.body
            imbBack.setOnClickListener {
                dismiss()
            }
        }
    }
}