package com.bemo.client.dialog

import android.content.Context
import android.view.LayoutInflater
import com.bemo.client.CompanyInfoReview
import com.bemo.client.databinding.DialReviewBinding

class ReviewDialog(context: Context): CustomDialog(context) {

    init {
        mBinding = DialReviewBinding.inflate(LayoutInflater.from(context)).apply {
            btnExit.setOnClickListener {
                dismiss()
            }

            btnOk.setOnClickListener {
                // TODO: 리뷰 API 호출
            }
        }
        setSize(width = (context.resources.displayMetrics.widthPixels * 0.8).toInt(),
            height = (context.resources.displayMetrics.heightPixels * 0.6).toInt())
    }

    constructor(context: Context, item: CompanyInfoReview) : this(context) {
        (mBinding as DialReviewBinding).apply {
            ratingReview.rating = item.rating
            editReview.setText(item.desc)
        }
    }
}