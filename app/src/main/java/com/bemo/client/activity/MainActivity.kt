package com.bemo.client.activity

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.bemo.client.MainViewAdapter
import com.bemo.client.R
import com.bemo.client.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val adapter = MainViewAdapter(supportFragmentManager)
        mBinding.pagerMain.adapter = adapter
        mBinding.tabMain.setupWithViewPager(mBinding.pagerMain)

        setTab()

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

    private fun setTab() {
        val texts = arrayOf("홈", "검색 결과", "마이")
        val icons = arrayOf(R.mipmap.iconhome, R.mipmap.iconresult, R.mipmap.iconmy)

        for(i in texts.indices) {
            val tab = mBinding.tabMain.getTabAt(i)!!
            tab.text = texts[i]
            tab.setIcon(icons[i])
            tab.icon?.setColorFilter(resources.getColor(R.color.gray), PorterDuff.Mode.SRC_IN)
        }
        mBinding.tabMain.getTabAt(0)!!.icon?.setColorFilter(resources.getColor(R.color.blue), PorterDuff.Mode.SRC_IN)
    }
}