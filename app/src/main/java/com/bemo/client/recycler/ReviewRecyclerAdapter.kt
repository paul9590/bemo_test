package com.bemo.client.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.*

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
        val map = HashMap<Int, Int>()
        map[TYPE_COMPANY] = R.layout.list_company_info_company
        map[TYPE_TEXT] = R.layout.list_company_info_text

        val view = LayoutInflater.from(context).inflate(map[viewType]!!, parent, false)

        return ReviewViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
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
            TYPE_REVIEW -> {
                item as CompanyInfoReview
                holder.img.setImageResource(item.img)
                holder.rating.rating = item.rating
                holder.desc[0].text = item.desc
                holder.desc[1].text = item.date
            }
        }
    }

    override fun getItemViewType(p: Int): Int = mData[p].type

    override fun getItemCount(): Int = mData.size

    inner class ReviewViewHolder internal constructor(itemView: View, viewType: Int):
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
                TYPE_REVIEW -> {
                    name = itemView.findViewById(R.id.txtCompanyInfoReviewTitle)
                    img = itemView.findViewById(R.id.imgCompanyInfoReview)
                    rating = itemView.findViewById(R.id.ratingCompanyInfoReview)
                    desc.add(itemView.findViewById(R.id.txtCompanyInfoReviewBody))
                    desc.add(itemView.findViewById(R.id.txtCompanyInfoReviewDate))
                }
            }
        }

    }
}