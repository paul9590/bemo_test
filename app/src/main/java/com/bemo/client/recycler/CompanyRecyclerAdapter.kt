package com.bemo.client.recycler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.Company
import com.bemo.client.R
import com.bemo.client.activity.CompanyActivity
import com.bemo.client.databinding.ListCompanyBinding

class CompanyRecyclerAdapter(data: ArrayList<Company>) :
    RecyclerView.Adapter<CompanyRecyclerAdapter.CompanyViewHolder>(){
    private val mData: ArrayList<Company>
    private lateinit var context : Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {

        context = parent.context

        return CompanyViewHolder(ListCompanyBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        val item: Company = mData[position]
        holder.mBinding.chkFavorite.isChecked = item.favorite
        holder.mBinding.imgThumbs.setImageResource(0)
        if(item.isPremium) {
            holder.mBinding.imgThumbs.setImageResource(R.drawable.img_thumbs)
        }
        holder.mBinding.chkFavorite.setOnClickListener {
            // 찜 목록 클릭 시 서버 통신
            item.favorite = !holder.mBinding.chkFavorite.isChecked
        }
        holder.mBinding.imgCompany.setImageResource(item.img)
        holder.mBinding.txtCompany1.text = item.name
        holder.mBinding.txtCompanyAddress.text = item.address
        holder.mBinding.txtCompanyTarget.text = item.target
        holder.mBinding.txtCompanyDistance.text = item.distance

        // 업체 상세 페이지로 이동
        holder.mBinding.root.setOnClickListener {
            val intent = Intent(context, CompanyActivity::class.java)
            intent.putExtra("company", item)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = mData.size

    inner class CompanyViewHolder internal constructor(val mBinding: ListCompanyBinding) :
        RecyclerView.ViewHolder(mBinding.root)
}