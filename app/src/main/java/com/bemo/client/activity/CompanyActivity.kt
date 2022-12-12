package com.bemo.client.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bemo.client.*
import com.bemo.client.viewadapter.CompanyInfoViewAdapter
import com.bemo.client.databinding.ActivityCompanyBinding

class CompanyActivity : AppCompatActivity(){
    private lateinit var mBinding: ActivityCompanyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCompanyBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val company = intent.getSerializableExtra("company") as Company
        val adapter = CompanyInfoViewAdapter(company, supportFragmentManager)

        mBinding.apply {
            txtCompanyTitle.text = company.name
            pagerCompany.adapter = adapter
            tabCompany.setupWithViewPager(mBinding.pagerCompany)
        }

        mBinding.imbBack.setOnClickListener {
            finish()
        }
        
        setTab()
    }

    private fun setTab() {

        // TODO: 학원 정보 API 호출
        val texts = arrayOf("기본", "강사소개", "상세", "시설사진", "리뷰")

        for(i in texts.indices) {
            val tab = mBinding.tabCompany.getTabAt(i)!!
            tab.text = texts[i]
        }
    }

}