package com.bemo.client.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bemo.client.activity.MainActivity
import com.bemo.client.activity.PointActivity
import com.bemo.client.activity.ReviewActivity
import com.bemo.client.activity.SettingActivity
import com.bemo.client.databinding.FragmentMyBinding
import com.bemo.client.viewadapter.ViewAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mBinding: FragmentMyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mBinding = FragmentMyBinding.inflate(inflater, container, false)

        setTab()

        mBinding.imbBack.setOnClickListener {
            (activity as MainActivity).viewHome()
        }

        mBinding.btnReview.setOnClickListener {
            val intent = Intent(activity, ReviewActivity :: class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        mBinding.imgSetting.setOnClickListener {
            val intent = Intent(activity, SettingActivity :: class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        mBinding.btnPoint.setOnClickListener {
            val intent = Intent(activity, PointActivity :: class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        return mBinding.root
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            MyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setTab() {

        // 로그인 정보 불러오기
        mBinding.txtMy.text = "김종민님,\n안녕하세요!!"
        val adapter = ViewAdapter(childFragmentManager)
        adapter.addList(LatestFragment())
        adapter.addList(FavoriteFragment())
        mBinding.pagerMy.adapter = adapter
        mBinding.tabMy.setupWithViewPager(mBinding.pagerMy)

        val texts = arrayOf("최근 본", "찜")

        for(i in texts.indices) {
            val tab = mBinding.tabMy.getTabAt(i)!!
            tab.text = texts[i]
        }
    }
}