package com.bemo.client

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bemo.client.fragment.CompanyDefaultFragment
import com.bemo.client.fragment.CompanyInfoFragment
import com.bemo.client.fragment.CompanyReviewFragment

class CompanyViewAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
){
    private val fragList = ArrayList<Fragment>()

    init {
        fragList.add(CompanyDefaultFragment())
        fragList.add(CompanyInfoFragment())
        fragList.add(CompanyInfoFragment())
        fragList.add(CompanyInfoFragment())
        fragList.add(CompanyReviewFragment())
    }

    override fun getCount(): Int {
        return fragList.size
    }

    override fun getItem(p0: Int): Fragment = fragList[p0]
}