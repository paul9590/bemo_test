package com.bemo.client.recycler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.Company
import com.bemo.client.R
import com.bemo.client.activity.CompanyActivity
import com.bemo.client.databinding.ListCompanyBinding

class CompanyRecyclerAdapter :
    RecyclerView.Adapter<CustomViewHolder>(){
    private var mData = ArrayList<Company>()
    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        context = parent.context

        return CustomViewHolder(ListCompanyBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item: Company = mData[position]
        (holder.mBinding as ListCompanyBinding).apply {
            chkFavorite.isChecked = item.favorite
            imgThumbs.setImageResource(0)
            if(item.isPremium) {
                imgThumbs.setImageResource(R.drawable.img_thumbs)
            }
            chkFavorite.setOnClickListener {
                // TODO: 찜 목록 등록 API 호출
                item.favorite = !chkFavorite.isChecked
            }
            imgCompany.setImageResource(item.img)
            txtCompany1.text = item.name
            txtCompanyAddress.text = item.address
            txtCompanyTarget.text = item.target
            txtCompanyDistance.text = item.distance

            // 업체 상세 페이지로 이동
            root.setOnClickListener {
                val intent = Intent(context, CompanyActivity::class.java)
                intent.putExtra("company", item)
                context.startActivity(intent)
            }
        }
    }

    internal fun setData(newItems: ArrayList<Company>) {
        this.mData = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = mData.size
}