package com.bemo.client.viewadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bemo.client.*
import com.bemo.client.fragment.ReviewFragment

class ReviewViewAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
){
    private val fragList = ArrayList<ReviewFragment>()

    init {
        fragList.add(ReviewFragment())
        fragList.add(ReviewFragment())

        setReviewInfo()
    }

    override fun getCount(): Int {
        return fragList.size
    }

    override fun getItem(p0: Int): Fragment = fragList[p0]

    private fun setReviewInfo() {
        val list = ArrayList<CompanyInfo>()
        val sb = StringBuilder()
        repeat(100) {
            sb.append("가나다라마바사아자차카타파하")
        }
        list.add(CompanyInfoText("상세 설명", desc = sb.toString()))
        list.add(CompanyInfoImg("이미지", R.drawable.img_default_company_info))
        list.add(CompanyInfoCareer("김종민", "2016년 도농고 졸업\n\n2021년 시집 출판\n\n2022년", R.drawable.img_default_company_info_career, "대표?"))
        for(i in 0 .. 1) {
            fragList[i].addList(list)
        }
    }
}