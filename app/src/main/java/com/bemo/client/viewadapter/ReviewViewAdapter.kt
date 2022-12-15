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
        setReview1()
        setReview2()
    }

    private fun setReview1() {
        val list = ArrayList<CompanyInfo>()
        repeat(10) {
            list.add(
                Company(
                    name ="업체 이름",
                    img = R.drawable.img_place1,
                    isPremium = true,
                    favorite = true,
                    address = "경기도 남양주시 도농동",
                    target = "10대",
                    distance = "1km",
                )
            )
        }
        fragList[0].addList(list)
    }

    private fun setReview2() {
        val list = ArrayList<CompanyInfo>()
        repeat(10) {
            list.add(
                CompanyInfoReview(
                    name = "송수학학원",
                    date = "2022/08/18",
                    rating = 2.6f,
                    desc = "가나다라마바사아자차카타파하"
                )
            )
        }
        fragList[1].addList(list)
    }
}