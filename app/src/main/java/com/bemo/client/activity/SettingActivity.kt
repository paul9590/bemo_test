package com.bemo.client.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.*
import com.bemo.client.databinding.ActivitySettingBinding
import com.bemo.client.recycler.SettingRecyclerAdapter

class SettingActivity : AppCompatActivity(){
    private lateinit var mBinding: ActivitySettingBinding
    private val mList = ArrayList<Setting>()
    private val mAdapter = SettingRecyclerAdapter(mList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.viewSetting.adapter = mAdapter
        mBinding.viewSetting.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)

        addList()
        mBinding.txtVersion.text = "Version ${packageManager.getPackageInfo(packageName, 0).versionName}"

    }

    private fun addList() {
        mList += Setting("공지사항", Intent(applicationContext, SettingActivity :: class.java))
        mList += Setting("자주 묻는 질문", Intent(applicationContext, SettingActivity :: class.java))
        mList += Setting("고객센터", Intent(applicationContext, SettingActivity :: class.java))
        mList += Setting("알림 설정", Intent(applicationContext, SettingActivity :: class.java))
        mList += Setting("제휴 및 광고 문의", Intent(applicationContext, SettingActivity :: class.java))
        mList += Setting("약관 및 정책", Intent(applicationContext, SettingActivity :: class.java))
        mList += Setting("계정 탈퇴 및 삭제", Intent(applicationContext, SettingActivity :: class.java))
    }
}