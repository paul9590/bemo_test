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
    RecyclerView.Adapter<CustomViewHolder>(){
    private val mData: ArrayList<CompanyInfo>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        context = parent.context
        return when(viewType) {
            COMPANY_COMPANY -> CustomViewHolder(ListCompanyInfoCompanyBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_TEXT -> CustomViewHolder(ListCompanyInfoTextBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_IMG -> CustomViewHolder(ListCompanyInfoImgBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_CAREER -> CustomViewHolder(ListCompanyInfoCareerBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_REVIEW_AVG -> CustomViewHolder(ListCompanyInfoReviewAvgBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_REVIEW -> CustomViewHolder(ListCompanyInfoReviewBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_CATEGORY -> CustomViewHolder(ListCompanyInfoCategoryBinding.inflate(LayoutInflater.from(context), parent, false))
            COMPANY_MAP -> CustomViewHolder(ListCompanyInfoMapBinding.inflate(LayoutInflater.from(context), parent, false))

            else -> CustomViewHolder(ListCompanyInfoCompanyBinding.inflate(LayoutInflater.from(context), parent, false))
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
                (mBinding as ListCompanyInfoCompanyBinding).apply {
                    txtCompanyName.text = item.name
                    imgCompany.setImageResource(item.img)
                    txtCompanyAddress.text = item.address
                    txtCompanyTarget.text = item.target
                    txtCompanyDistance.text = item.distance
                    
                    // TODO: 하이
                    txtCompanyUtility.text = "셔틀버스 있음\n셔틀버스 있음\n셔틀버스 있음\n셔틀버스 있음\n셔틀버스 있음\n"
                    txtCompanyUtility.collapse()
                }
            }
            COMPANY_TEXT -> {
                item as CompanyInfoText
                (mBinding as ListCompanyInfoTextBinding).apply {
                    txtCompanyInfoTxt.text = item.name
                    txtCompanyInfo.text = item.desc
                }
            }
            COMPANY_IMG -> {
                item as CompanyInfoImg
                (mBinding as ListCompanyInfoImgBinding).apply {
                    txtCompanyInfoName.text = item.name
                    imgCompanyInfo.setImageResource(item.img)
                }
            }
            COMPANY_CAREER -> {
                item as CompanyInfoCareer
                (mBinding as ListCompanyInfoCareerBinding).apply {
                    txtCareerName.text = item.name
                    imgCareer.setImageResource(item.img)
                    txtCareerRank.text = item.rank
                    txtCareerDetail.text = item.desc
                }
            }
            COMPANY_REVIEW_AVG -> {
                item as CompanyInfoReviewAvg
                (mBinding as ListCompanyInfoReviewAvgBinding).apply {
                    txtCompanyInfoReviewCnt.text = item.name
                    txtCompanyReviewAvg.text = DecimalFormat("#.##").format(item.rating).toString()
                    ratingCompanyInfoReviewAvg.rating = item.rating
                }
            }
            COMPANY_REVIEW -> {
                item as CompanyInfoReview
                (mBinding as ListCompanyInfoReviewBinding).apply {
                    txtCompanyInfoReviewTitle.text = item.name
                    imgCompanyInfoReview.setImageResource(item.img)
                    ratingCompanyInfoReview.rating = item.rating
                    txtCompanyInfoReviewBody.text = item.desc
                    txtCompanyInfoReviewDate.text = item.date
                }
            }
            COMPANY_CATEGORY -> {
                item as CompanyInfoCategory
                (mBinding as ListCompanyInfoCategoryBinding).apply {
                    btnCategory1.text = item.name
                    btnCategory2.text = item.name2
                    btnCategory3.text = item.name3
                }
            }
            COMPANY_MAP -> {
                item as CompanyInfoMap
                (mBinding as ListCompanyInfoMapBinding).apply {
                    imgCompanyMap.setImageResource(item.img)

                }
            }
        }
    }

    override fun getItemViewType(p: Int): Int = mData[p].type

    override fun getItemCount(): Int = mData.size
}