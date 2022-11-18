package com.bemo.client.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bemo.client.databinding.ActivityReviewBinding
import com.bemo.client.viewadapter.ReviewViewAdapter

class ReviewActivity: AppCompatActivity() {
    private lateinit var mBinding: ActivityReviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val adapter = ReviewViewAdapter(supportFragmentManager)
        mBinding.pagerReview.adapter = adapter
        mBinding.tabReview.setupWithViewPager(mBinding.pagerReview)
        mBinding.imgBack.setOnClickListener {
            finish()
        }
        setTab()
    }

    private fun setTab() {
        val texts = arrayOf("미작성 리뷰", "작성한 리뷰")

        for(i in texts.indices) {
            val tab = mBinding.tabReview.getTabAt(i)!!
            tab.text = texts[i]
        }
    }
}