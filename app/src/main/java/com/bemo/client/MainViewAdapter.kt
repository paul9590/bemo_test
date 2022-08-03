package com.bemo.client

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bemo.client.fragment.HomeFragment
import com.bemo.client.fragment.MyFragment
import com.bemo.client.fragment.ResultFragment

class MainViewAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val fragList = ArrayList<Fragment>()

    init {
        fragList.add(HomeFragment())
        fragList.add(ResultFragment())
        fragList.add(MyFragment())
    }

    override fun getCount(): Int {
        return fragList.size
    }

    override fun getItem(p0: Int): Fragment = fragList[p0]
}