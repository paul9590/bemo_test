package com.bemo.client

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.bemo.client.fragment.HomeFragment
import com.bemo.client.fragment.MyFragment
import com.bemo.client.fragment.ResultFragment

class MainViewAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm){
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