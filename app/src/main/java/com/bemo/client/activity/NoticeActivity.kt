package com.bemo.client.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.Info
import com.bemo.client.R
import com.bemo.client.databinding.ActivityInfoBinding
import com.bemo.client.recycler.NoticeRecyclerAdapter

class NoticeActivity: AppCompatActivity() {
    private lateinit var mBinding : ActivityInfoBinding
    private val mList = ArrayList<Info>()
    private val mAdapter = NoticeRecyclerAdapter(mList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.txtTitle.text = getString(R.string.notice_title)



        mBinding.viewNotice.adapter = mAdapter
        mBinding.viewNotice.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)

        mBinding.imbBack.setOnClickListener {
            finish()
        }
        addList()
    }

    private fun addList() {
        mList += Info("따뜻한 봄바람이다 인생에 따뜻한 봄바람을", "고동을 들어 보라 청춘의 피는 끓는다 끓는 피에 뛰노는 심장은 거선의 기관과 같이 힘있다 이것이다 인류의 역사를 꾸며 내려온 동력은 바로 이것이다 이성은 투명하되 얼음과 같으며 지혜는 날카로우나 갑 속에 든 칼이다")
    }
}