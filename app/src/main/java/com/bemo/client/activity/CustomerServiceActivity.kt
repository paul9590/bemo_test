package com.bemo.client.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bemo.client.R
import com.bemo.client.databinding.ActivityCustomerServiceBinding

class CustomerServiceActivity: AppCompatActivity() {
    private lateinit var mBinding : ActivityCustomerServiceBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCustomerServiceBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.btnKakao.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.customer_service_kakao_uri))))
        }
        mBinding.btnEmail.setOnClickListener {
            val email = Intent(Intent.ACTION_SEND)
            email.type = "plain/text"
            email.putExtra(Intent.EXTRA_EMAIL, getString(R.string.customer_service_email))
            startActivity(email)
        }
        mBinding.btnExit.setOnClickListener {
            finish()
        }
    }
}