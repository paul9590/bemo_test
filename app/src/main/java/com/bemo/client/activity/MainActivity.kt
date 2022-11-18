package com.bemo.client.activity

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bemo.client.viewadapter.MainViewAdapter
import com.bemo.client.R
import com.bemo.client.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setTab()
    }

    private fun setTab() {

        val adapter = MainViewAdapter(supportFragmentManager)
        mBinding.pagerMain.adapter = adapter
        mBinding.tabMain.setupWithViewPager(mBinding.pagerMain)

        val texts = arrayOf("홈", "검색 결과", "마이")
        val icons = arrayOf(R.drawable.icon_home, R.drawable.icon_result, R.drawable.icon_my)

        for(i in texts.indices) {
            val tab = mBinding.tabMain.getTabAt(i)!!
            tab.text = texts[i]
            tab.setIcon(icons[i])
            tab.icon?.setColorFilter(resources.getColor(R.color.gray), PorterDuff.Mode.SRC_IN)
        }
        mBinding.tabMain.getTabAt(0)!!.icon?.setColorFilter(resources.getColor(R.color.blue), PorterDuff.Mode.SRC_IN)

        mBinding.tabMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(p0: TabLayout.Tab?) {
                mBinding.pagerMain.currentItem = p0!!.position
                p0.icon?.setColorFilter(resources.getColor(R.color.blue), PorterDuff.Mode.SRC_IN)
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                p0!!.icon?.setColorFilter(resources.getColor(R.color.gray), PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {
            }
        })
    }

    fun backPressed() {
        mBinding.pagerMain.setCurrentItem(0, true)
    }
}