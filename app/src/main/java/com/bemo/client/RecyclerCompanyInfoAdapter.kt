package com.bemo.client

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.DecimalFormat
import kotlin.math.roundToInt

class RecyclerCompanyInfoAdapter(data: ArrayList<CompanyInfo>):
    RecyclerView.Adapter<RecyclerCompanyInfoAdapter.CompanyInfoViewHolder>(){
    private val mData: ArrayList<CompanyInfo>
    private lateinit var context: Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int):
            RecyclerCompanyInfoAdapter.CompanyInfoViewHolder {

        context = parent.context
        // create a new view-
        val map = HashMap<Int, Int>()
        map[TYPE_COMPANY] = R.layout.list_company_info_company
        map[TYPE_TEXT] = R.layout.list_company_info_text
        map[TYPE_IMG] = R.layout.list_company_info_img
        map[TYPE_CAREER] = R.layout.list_company_info_career
        map[TYPE_REVIEW_AVG] = R.layout.list_company_info_review_avg
        map[TYPE_REVIEW] = R.layout.list_company_info_review
        map[TYPE_CATEGORY] = R.layout.list_company_info_category
        map[TYPE_MAP] = R.layout.list_company_info_map

        val view = LayoutInflater.from(context).inflate(map[viewType]!!, parent, false)
        return CompanyInfoViewHolder(view, viewType)
    }

    // onBindViewHolder : position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    override fun onBindViewHolder(holder: RecyclerCompanyInfoAdapter.CompanyInfoViewHolder, position: Int) {
        val item: CompanyInfo = mData[position]

        if(holder.name != null) {
            holder.name!!.text = item.name
        }

        when(mData[position].type) {
            TYPE_COMPANY -> {
                item as Company
                holder.img.setImageResource(item.img)
                holder.desc[0].text = item.address
                holder.desc[1].text = item.target
                holder.desc[2].text = item.distance
                if(item.shuttle) {
                    holder.desc[3].text = "셔틀버스 있음"
                    holder.desc[3].setTextColor(context.resources.getColor(R.color.blue))
                }else {
                    holder.desc[3].text = "셔틀버스 없음"
                    holder.desc[3].setTextColor(context.resources.getColor(R.color.red))
                }
            }
            TYPE_TEXT -> {
                item as CompanyInfoText
                holder.desc[0].text = item.desc
            }
            TYPE_IMG -> {
                item as CompanyInfoImg
                holder.img.setImageResource(item.img)
            }
            TYPE_CAREER -> {
                item as CompanyInfoCareer
                holder.txtRank.text = item.rank
                holder.img.setImageResource(item.img)
                holder.desc[0].text = item.desc
            }
            TYPE_REVIEW_AVG -> {
                item as CompanyInfoReviewAvg
                holder.rating.rating = item.rating
                holder.desc[0].text = DecimalFormat("#.##").format(item.rating).toString()
            }
            TYPE_REVIEW -> {
                item as CompanyInfoReview
                holder.img.setImageResource(item.img)
                holder.rating.rating = item.rating
                holder.desc[0].text = item.desc
                holder.desc[1].text = item.date
            }
            TYPE_CATEGORY -> {
                item as CompanyInfoCategory
                holder.btn[0].text = item.name
                holder.btn[1].text = item.name2
                holder.btn[2].text = item.name3
            }
            TYPE_MAP -> {
                item as CompanyInfoMap
                holder.img.setImageResource(item.img)
            }
        }
    }

    override fun getItemViewType(p: Int): Int = mData[p].type

    override fun getItemCount(): Int = mData.size

    inner class CompanyInfoViewHolder internal constructor(itemView: View, viewType: Int):
        RecyclerView.ViewHolder(itemView){
        var name: TextView? = null
        lateinit var img: ImageView
        lateinit var txtRank: TextView
        lateinit var rating: RatingBar
        val desc = ArrayList<TextView>()
        val btn = ArrayList<Button>()

        init {
            when(viewType) {
                TYPE_COMPANY -> {
                    name = itemView.findViewById(R.id.txtCompanyName)
                    img = itemView.findViewById(R.id.imgCompany)
                    desc.add(itemView.findViewById(R.id.txtCompanyAddress))
                    desc.add(itemView.findViewById(R.id.txtCompanyTarget))
                    desc.add(itemView.findViewById(R.id.txtCompanyDistance))
                    desc.add(itemView.findViewById(R.id.txtCompanyShuttle))
                }
                TYPE_TEXT -> {
                    name = itemView.findViewById(R.id.txtCompanyInfoTxt)
                    desc.add(itemView.findViewById(R.id.txtCompanyInfo))
                }
                TYPE_IMG -> {
                    name = itemView.findViewById(R.id.txtCompanyInfoImg)
                    img = itemView.findViewById(R.id.imgCompanyInfo)
                }
                TYPE_CAREER -> {
                    name = itemView.findViewById(R.id.txtCompanyCareerName)
                    img = itemView.findViewById(R.id.imgCompanyCareer)
                    txtRank = itemView.findViewById(R.id.txtCompanyCareerRank)
                    desc.add(itemView.findViewById(R.id.txtCompanyCareerCareer))
                }
                TYPE_REVIEW_AVG -> {
                    name = itemView.findViewById(R.id.txtCompanyInfoReviewCnt)
                    rating = itemView.findViewById(R.id.ratingCompanyInfoReviewAvg)
                    desc.add(itemView.findViewById(R.id.txtCompanyReviewAvg))
                }
                TYPE_REVIEW -> {
                    name = itemView.findViewById(R.id.txtCompanyInfoReviewTitle)
                    img = itemView.findViewById(R.id.imgCompanyInfoReview)
                    rating = itemView.findViewById(R.id.ratingCompanyInfoReview)
                    desc.add(itemView.findViewById(R.id.txtCompanyInfoReviewBody))
                    desc.add(itemView.findViewById(R.id.txtCompanyInfoReviewDate))
                }
                TYPE_CATEGORY -> {
                    btn.add(itemView.findViewById(R.id.btnCategory1))
                    btn.add(itemView.findViewById(R.id.btnCategory2))
                    btn.add(itemView.findViewById(R.id.btnCategory3))
                }
                TYPE_MAP -> {
                    img = itemView.findViewById(R.id.imgCompanyMap)
                }
            }
        }

    }
}