package com.bemo.client.viewadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val fragList = ArrayList<Fragment>()

    override fun getCount(): Int {
        return fragList.size
    }
    fun addList(fragment: Fragment) {
        fragList += fragment
    }

    override fun getItem(p0: Int): Fragment = fragList[p0]
}