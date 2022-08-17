package com.bemo.client.viewadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bemo.client.fragment.FavoriteFragment
import com.bemo.client.fragment.LatestFragment

class MyViewAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val fragList = ArrayList<Fragment>()

    init {
        fragList.add(LatestFragment())
        fragList.add(FavoriteFragment())
    }

    override fun getCount(): Int {
        return fragList.size
    }

    override fun getItem(p0: Int): Fragment = fragList[p0]
}