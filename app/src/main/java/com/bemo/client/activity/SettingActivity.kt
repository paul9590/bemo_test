package com.bemo.client.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.*
import com.bemo.client.databinding.ActivitySettingBinding
import com.bemo.client.recycler.InfoRecyclerAdapter

class SettingActivity : AppCompatActivity(){
    private lateinit var mBinding: ActivitySettingBinding
    private val mList = ArrayList<InfoIntent>()
    private val mAdapter = InfoRecyclerAdapter(mList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.viewSetting.adapter = mAdapter
        mBinding.viewSetting.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        mBinding.imbBack.setOnClickListener {
            finish()
        }

        addList()
        mBinding.txtVersion.text = "Version ${packageManager.getPackageInfo(packageName, 0).versionName}"

    }

    private fun addList() {
        mList += InfoIntent("공지사항", Intent(applicationContext, NoticeActivity :: class.java))
        mList += InfoIntent("자주 묻는 질문", Intent(applicationContext, SettingActivity :: class.java))
        mList += InfoIntent("고객센터", Intent(applicationContext, CustomerServiceActivity :: class.java))
        mList += InfoIntent("알림 설정", Intent(applicationContext, SettingActivity :: class.java))
        mList += InfoIntent("제휴 및 광고 문의", Intent(applicationContext, SettingActivity :: class.java))
        mList += InfoIntent("약관 및 정책", Intent(applicationContext, LawActivity :: class.java))
        mList += InfoIntent("계정 탈퇴 및 삭제", Intent(applicationContext, SettingActivity :: class.java))
    }
}