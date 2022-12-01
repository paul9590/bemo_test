package com.bemo.client

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.Window
import com.bemo.client.databinding.DialReviewBinding

class ReviewDialog(val context: Context) {
    private val dial = Dialog(context)
    private var mBinding: DialReviewBinding = DialReviewBinding.inflate(LayoutInflater.from(context))

    constructor(context: Context, item: CompanyInfoReview) : this(context) {
        mBinding.ratingReview.rating = item.rating
        mBinding.editReview.setText(item.desc)
    }

    
    init {
        mBinding.btnExit.setOnClickListener {
            dial.dismiss()
        }

        mBinding.btnOk.setOnClickListener {
            // 리뷰 작성
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

        dial.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}