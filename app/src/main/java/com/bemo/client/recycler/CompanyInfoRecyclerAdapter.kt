package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bemo.client.*
import com.bemo.client.databinding.*
import java.text.DecimalFormat

class CompanyInfoRecyclerAdapter(data: ArrayList<CompanyInfo>):
    RecyclerView.Adapter<CompanyInfoRecyclerAdapter.CompanyInfoViewHolder>(){
    private val mData: ArrayList<CompanyInfo>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyInfoViewHolder {

        context = parent.context
        return when(viewType) {
            TYPE_COMPANY -> CompanyInfoViewHolder(ListCompanyInfoCompanyBinding.inflate(LayoutInflater.from(context), parent, false))
            TYPE_TEXT -> CompanyInfoViewHolder(ListCompanyInfoTextBinding.inflate(LayoutInflater.from(context), parent, false))
            TYPE_IMG -> CompanyInfoViewHolder(ListCompanyInfoImgBinding.inflate(LayoutInflater.from(context), parent, false))
            TYPE_CAREER -> CompanyInfoViewHolder(ListCompanyInfoCareerBinding.inflate(LayoutInflater.from(context), parent, false))
            TYPE_REVIEW_AVG -> CompanyInfoViewHolder(ListCompanyInfoReviewAvgBinding.inflate(LayoutInflater.from(context), parent, false))
            TYPE_REVIEW -> CompanyInfoViewHolder(ListCompanyInfoReviewBinding.inflate(LayoutInflater.from(context), parent, false))
            TYPE_CATEGORY -> CompanyInfoViewHolder(ListCompanyInfoCategoryBinding.inflate(LayoutInflater.from(context), parent, false))
            TYPE_MAP -> CompanyInfoViewHolder(ListCompanyInfoMapBinding.inflate(LayoutInflater.from(context), parent, false))

            else -> CompanyInfoViewHolder(ListCompanyInfoCompanyBinding.inflate(LayoutInflater.from(context), parent, false))
        }

    }

    override fun onBindViewHolder(holder: CompanyInfoViewHolder, position: Int) {
        val item: CompanyInfo = mData[position]
        val mBinding = holder.mBinding
        bind(item, mBinding)
    }

    private fun bind(item: CompanyInfo, mBinding: ViewBinding) {

        when(item.type) {
            TYPE_COMPANY -> {
                item as Company
                mBinding as ListCompanyInfoCompanyBinding
                mBinding.txtCompanyName.text = item.name
                mBinding.imgCompany.setImageResource(item.img)
                mBinding.txtCompanyAddress.text = item.address
                mBinding.txtCompanyTarget.text = item.target
                mBinding.txtCompanyDistance.text = item.distance
                if(item.shuttle) {
                    mBinding.txtCompanyShuttle.text = "셔틀버스 있음"
                    mBinding.txtCompanyShuttle.setTextColor(context.resources.getColor(R.color.blue))
                }else {
                    mBinding.txtCompanyShuttle.text = "셔틀버스 없음"
                    mBinding.txtCompanyShuttle.setTextColor(context.resources.getColor(R.color.red))
                }
                if(item.lesson) {
                    mBinding.txtCompanyLesson.text = "비대면 강의 있음"
                    mBinding.txtCompanyLesson.setTextColor(context.resources.getColor(R.color.blue))
                }else {
                    mBinding.txtCompanyLesson.text = "비대면 강의 없음"
                    mBinding.txtCompanyLesson.setTextColor(context.resources.getColor(R.color.red))
                }
            }
            TYPE_TEXT -> {
                item as CompanyInfoText
                mBinding as ListCompanyInfoTextBinding
                mBinding.txtCompanyInfoTxt.text = item.name
                mBinding.txtCompanyInfo.text = item.desc
            }
            TYPE_IMG -> {
                item as CompanyInfoImg
                mBinding as ListCompanyInfoImgBinding
                mBinding.txtCompanyInfoName.text = item.name
                mBinding.imgCompanyInfo.setImageResource(item.img)
            }
            TYPE_CAREER -> {
                item as CompanyInfoCareer
                mBinding as ListCompanyInfoCareerBinding
                mBinding.txtCareerName.text = item.name
                mBinding.imgCareer.setImageResource(item.img)
                mBinding.txtCareerRank.text = item.rank
                mBinding.txtCareerDetail.text = item.desc
            }
            TYPE_REVIEW_AVG -> {
                item as CompanyInfoReviewAvg
                mBinding as ListCompanyInfoReviewAvgBinding
                mBinding.txtCompanyInfoReviewCnt.text = item.name
                mBinding.txtCompanyReviewAvg.text = DecimalFormat("#.##").format(item.rating).toString()
                mBinding.ratingCompanyInfoReviewAvg.rating = item.rating
            }
            TYPE_REVIEW -> {
                item as CompanyInfoReview
                mBinding as ListCompanyInfoReviewBinding
                mBinding.txtCompanyInfoReviewTitle.text = item.name
                mBinding.imgCompanyInfoReview.setImageResource(item.img)
                mBinding.ratingCompanyInfoReview.rating = item.rating
                mBinding.txtCompanyInfoReviewBody.text = item.desc
                mBinding.txtCompanyInfoReviewDate.text = item.date
            }
            TYPE_CATEGORY -> {
                item as CompanyInfoCategory
                mBinding as ListCompanyInfoCategoryBinding
                mBinding.btnCategory1.text = item.name
                mBinding.btnCategory2.text = item.name2
                mBinding.btnCategory3.text = item.name3
            }
            TYPE_MAP -> {
                item as CompanyInfoMap
                mBinding as ListCompanyInfoMapBinding
                mBinding.imgCompanyMap.setImageResource(item.img)
            }
        }
    }

    override fun getItemViewType(p: Int): Int = mData[p].type

    override fun getItemCount(): Int = mData.size

    inner class CompanyInfoViewHolder(val mBinding: ViewBinding):
        RecyclerView.ViewHolder(mBinding.root) {
    }
}