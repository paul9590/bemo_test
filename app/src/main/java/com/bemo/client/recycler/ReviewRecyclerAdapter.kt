package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bemo.client.*
import com.bemo.client.databinding.*
import com.bemo.client.dialog.ReviewDialog

class ReviewRecyclerAdapter(data: ArrayList<CompanyInfo>):
    RecyclerView.Adapter<CustomViewHolder>(){
    private val mData: ArrayList<CompanyInfo>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        context = parent.context
        // create a new view-
        return when(viewType) {
            COMPANY_COMPANY -> CustomViewHolder(ListMyReviewNeedFillBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            COMPANY_REVIEW -> CustomViewHolder(ListMyReviewFilledBinding.inflate(LayoutInflater.from(parent.context), parent, false))

            else -> CustomViewHolder(ListMyReviewNeedFillBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val item: CompanyInfo = mData[position]
        val mBinding = holder.mBinding
        bind(item, mBinding)
    }

    private fun bind(item: CompanyInfo, mBinding: ViewBinding) {
        when(item.type) {
            COMPANY_COMPANY -> {
                item as Company
                (mBinding as ListMyReviewNeedFillBinding).apply {
                    txtCompany1.text = item.name
                    imgCompany.setImageResource(item.img)
                    txtCompanyAddress.text = item.address
                    txtCompanyTarget.text = item.target
                    txtCompanyDistance.text = item.distance
                    btnReview.setOnClickListener {
                        ReviewDialog(context).show()
                    }
                }
            }
            COMPANY_REVIEW -> {
                item as CompanyInfoReview
                (mBinding as ListMyReviewFilledBinding).apply {
                    txtMyReviewCompany.text = item.name
                    ratingMyReview.rating = item.rating
                    txtMyReviewDate.text = item.date
                    txtMyReview.text = item.desc
                    btnEdit.setOnClickListener {
                        ReviewDialog(context, item).show()
                    }
                }
            }
        }
    }

    override fun getItemViewType(p: Int): Int = mData[p].type

    override fun getItemCount(): Int = mData.size
}