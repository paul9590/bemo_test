package com.bemo.client.activity

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bemo.client.viewadapter.ViewAdapter
import com.bemo.client.R
import com.bemo.client.databinding.ActivityMainBinding
import com.bemo.client.dialog.PopUpDialog
import com.bemo.client.fragment.HomeFragment
import com.bemo.client.fragment.MyFragment
import com.bemo.client.fragment.ResultFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setTab()
    }

    override fun onStart() {
        super.onStart()
        popUpDial()
    }

    private fun popUpDial() {
        PopUpDialog(this, resources.getDrawable(R.drawable.img_default_ad)).show()
    }

    private fun setTab() {

        val adapter = ViewAdapter(supportFragmentManager)
        adapter.addList(HomeFragment())
        adapter.addList(ResultFragment())
        adapter.addList(MyFragment())
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

    fun setHome() {
        mBinding.pagerMain.currentItem = 0
    }
}