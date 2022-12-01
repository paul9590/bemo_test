package com.bemo.client.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bemo.client.PointInfo
import com.bemo.client.R
import com.bemo.client.databinding.ActivityPointBinding
import com.bemo.client.fragment.PointFragment
import com.bemo.client.viewadapter.ViewAdapter

class PointActivity: AppCompatActivity() {
    private lateinit var mBinding : ActivityPointBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPointBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.txtTitle.text = getString(R.string.point_title)

        setTab()

        mBinding.imbBack.setOnClickListener {
            finish()
        }
    }

    private fun setTab() {
        val adapter = ViewAdapter(supportFragmentManager)
        addFragment(adapter)
        mBinding.pagerPoint.adapter = adapter
        mBinding.tabPoint.setupWithViewPager(mBinding.pagerPoint)

        val texts = arrayOf("상품", "상품권", "컨설팅")
        for(i in texts.indices) {
            mBinding.tabPoint.getTabAt(i)!!.text = texts[i]
        }
    }

    private fun addFragment(adapter: ViewAdapter) {
        repeat(3) {
            adapter.addList(addList())
        }
    }

    private fun addList(): PointFragment {
        val fragment = PointFragment()
        val mList = ArrayList<PointInfo>()
        repeat(10) {
            mList += PointInfo(title = "랜덤 뽑기", body = "당첨 시 최대 50만P\n" +
                    "1등 50만P 0.001%\n2등 10만P 0.01% \n" +
                    "3등 5만P 0.1%\n4등 1만P 1%\n" +
                    "5등 7천P 20%\n6등 3천p 30%\n" +
                    "7등 꽝 48.889%", img = R.drawable.img_point1)
        }
        fragment.setList(mList)
        return fragment
    }

}