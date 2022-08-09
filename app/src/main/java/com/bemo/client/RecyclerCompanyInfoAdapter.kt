package com.bemo.client

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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
        val view: View?

        return when(viewType) {
            TYPE_TEXT -> {
                view = LayoutInflater.from(context).inflate(R.layout.list_company_info_text, parent, false)
                CompanyInfoViewHolder(view, TYPE_TEXT)
            }
            TYPE_IMG -> {
                view = LayoutInflater.from(context).inflate(R.layout.list_company_info_img, parent, false)
                CompanyInfoViewHolder(view, TYPE_IMG)
            }
            TYPE_CAREER -> {
                view = LayoutInflater.from(context).inflate(R.layout.list_company_info_career, parent, false)
                CompanyInfoViewHolder(view, TYPE_CAREER)
            }

            else -> {
                view = LayoutInflater.from(context).inflate(R.layout.list_company_info_text, parent, false)
                CompanyInfoViewHolder(view, TYPE_TEXT)
            }
        }
    }

    // onBindViewHolder : position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    override fun onBindViewHolder(holder: RecyclerCompanyInfoAdapter.CompanyInfoViewHolder, position: Int) {
        val item: CompanyInfo = mData[position]

        holder.name.text = item.name

        when(mData[position].type) {
            TYPE_TEXT -> {
                holder.txt.text = item.desc
            }
            TYPE_IMG -> {
                holder.img.setImageResource(item.img)
            }
            TYPE_CAREER -> {
                holder.img.setImageResource(item.img)
                holder.txtRank.text = item.rank
                holder.txt.text = item.desc
            }
        }
    }

    override fun getItemViewType(p: Int): Int = mData[p].type

    override fun getItemCount(): Int = mData.size

    inner class CompanyInfoViewHolder internal constructor(itemView: View, viewType: Int):
        RecyclerView.ViewHolder(itemView){
        lateinit var name: TextView
        lateinit var img: ImageView
        lateinit var txt: TextView
        lateinit var txtRank: TextView


        init {
            when(viewType) {
                TYPE_TEXT -> {
                    name = itemView.findViewById(R.id.txtCompanyInfoTxt)
                    txt = itemView.findViewById(R.id.txtCompanyInfo)
                }
                TYPE_IMG -> {
                    name = itemView.findViewById(R.id.txtCompanyInfoImg)
                    img = itemView.findViewById(R.id.imgCompanyInfo)
                }
                TYPE_CAREER -> {
                    name = itemView.findViewById(R.id.txtCompanyCareerName)
                    img = itemView.findViewById(R.id.imgCompanyCareer)
                    txtRank = itemView.findViewById(R.id.txtCompanyCareerRank)
                    txt = itemView.findViewById(R.id.txtCompanyCareerCareer)
                }

            }
        }

    }
}