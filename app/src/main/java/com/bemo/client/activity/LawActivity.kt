package com.bemo.client.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.InfoIntent
import com.bemo.client.R
import com.bemo.client.databinding.ActivityInfoBinding
import com.bemo.client.recycler.InfoRecyclerAdapter

class LawActivity: AppCompatActivity() {
    private lateinit var mBinding : ActivityInfoBinding
    private val mList = ArrayList<InfoIntent>()
    private val mAdapter = InfoRecyclerAdapter(mList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.txtTitle.text = getString(R.string.law_title)



        mBinding.viewNotice.adapter = mAdapter
        mBinding.viewNotice.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)

        mBinding.imbBack.setOnClickListener {
            finish()
        }
        addList()
    }

    private fun addList() {
        mList += InfoIntent("따뜻한 봄바람이다 인생에 따뜻한 봄바람을", Intent(Intent.ACTION_VIEW, Uri.parse("https://naver.com")))
    }
}