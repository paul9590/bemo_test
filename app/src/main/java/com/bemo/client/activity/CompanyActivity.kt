package com.bemo.client.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bemo.client.*
import com.bemo.client.databinding.ActivityCompanyBinding
import com.bemo.client.fragment.CompanyInfoFragment

class CompanyActivity : AppCompatActivity(){
    private lateinit var mBinding: ActivityCompanyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCompanyBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val company = intent.getSerializableExtra("company") as Company
        mBinding.txtCompanyTitle.text = company.name

        val adapter = CompanyViewAdapter(supportFragmentManager)
        mBinding.pagerCompany.adapter = adapter
        mBinding.tabCompany.setupWithViewPager(mBinding.pagerCompany)
        setTab()
        val bundle = Bundle()
            bundle.putSerializable("company", company)
        adapter.getItem(0).arguments = bundle

        val list = ArrayList<CompanyInfo>()
        val sb = StringBuilder()
        repeat(100) {
            sb.append("가나다라마바사아자차카타파하")
        }
        list.add(CompanyInfo(TYPE_TEXT, "상세 설명", desc = sb.toString()))
        list.add(CompanyInfo(TYPE_IMG, "이미지", img = R.drawable.imgdefaultmy))
        list.add(CompanyInfo(TYPE_CAREER, "김종민", img = R.drawable.imgdefaultmy, desc = "2016년 도농고 졸업\n\n2021년 시집 출판\n\n2022년", rank = "대표?"))
        for(i in 1 .. 3) {
            val tab = adapter.getItem(i) as CompanyInfoFragment
            tab.addList(list)
        }
    }

    private fun setTab() {
        val texts = arrayOf("기본", "시설사진", "상세", "강사소개", "리뷰")

        for(i in texts.indices) {
            val tab = mBinding.tabCompany.getTabAt(i)!!
            tab.text = texts[i]
        }
    }
}