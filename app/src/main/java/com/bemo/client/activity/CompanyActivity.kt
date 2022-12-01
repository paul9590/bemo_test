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
        mBinding.txtCompanyTitle.text = company.name


        mBinding.imbBack.setOnClickListener {
            finish()
        }
        
        val adapter = CompanyInfoViewAdapter(company, supportFragmentManager)
        mBinding.pagerCompany.adapter = adapter
        mBinding.tabCompany.setupWithViewPager(mBinding.pagerCompany)
        setTab()
    }

    private fun setTab() {
        val texts = arrayOf("기본", "시설사진", "상세", "강사소개", "리뷰")

        for(i in texts.indices) {
            val tab = mBinding.tabCompany.getTabAt(i)!!
            tab.text = texts[i]
        }
    }

}