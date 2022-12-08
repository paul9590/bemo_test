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
    RecyclerView.Adapter<ReviewRecyclerAdapter.ReviewViewHolder>(){
    private val mData: ArrayList<CompanyInfo>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {

        context = parent.context
        // create a new view-
        return when(viewType) {
            COMPANY_COMPANY -> ReviewViewHolder(ListMyReviewNeedFillBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            COMPANY_REVIEW -> ReviewViewHolder(ListMyReviewFilledBinding.inflate(LayoutInflater.from(parent.context), parent, false))

            else -> ReviewViewHolder(ListMyReviewNeedFillBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {

        val item: CompanyInfo = mData[position]
        val mBinding = holder.mBinding
        bind(item, mBinding)
    }

    private fun bind(item: CompanyInfo, mBinding: ViewBinding) {
        when(item.type) {
            COMPANY_COMPANY -> {
                item as Company
                mBinding as ListMyReviewNeedFillBinding
                mBinding.txtCompany1.text = item.name
                mBinding.imgCompany.setImageResource(item.img)
                mBinding.txtCompanyAddress.text = item.address
                mBinding.txtCompanyTarget.text = item.target
                mBinding.txtCompanyDistance.text = item.distance
                mBinding.btnReview.setOnClickListener {
                    ReviewDialog(context).show()
                }
            }
            COMPANY_REVIEW -> {
                item as CompanyInfoReview
                mBinding as ListMyReviewFilledBinding
                mBinding.txtMyReviewCompany.text = item.name
                mBinding.ratingMyReview.rating = item.rating
                mBinding.txtMyReviewDate.text = item.date
                mBinding.txtMyReview.text = item.desc
                mBinding.btnEdit.setOnClickListener {
                    ReviewDialog(context, item).show()
                }
            }
        }
    }

    override fun getItemViewType(p: Int): Int = mData[p].type

    override fun getItemCount(): Int = mData.size

    inner class ReviewViewHolder(val mBinding: ViewBinding):
        RecyclerView.ViewHolder(mBinding.root){
    }
}