package com.bemo.client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class RecyclerCompanyAdapter(data: ArrayList<Company>) :
    RecyclerView.Adapter<RecyclerCompanyAdapter.CompanyViewHolder>(){
    private val mData: ArrayList<Company>

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int):
            RecyclerCompanyAdapter.CompanyViewHolder {
        // create a new view
            val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.list_company, parent, false)

        return CompanyViewHolder(view)
    }

    // onBindViewHolder : position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        val item: Company = mData[position]
        holder.chkFavortie.isChecked = item.farvorite
        holder.chkFavortie.setOnClickListener {
            // 찜 목록 클릭 시 서버 통신
            item.farvorite = !holder.chkFavortie.isChecked
        }
        holder.imgCompany.setImageResource(item.img)
        holder.address.text = item.address
        holder.target.text = item.target
        holder.distance.text = item.distance
    }

    // getItemCount : 전체 데이터의 개수를 리턴
    override fun getItemCount(): Int {
        return mData.size
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스
    inner class CompanyViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imgCompany : ImageView
        var chkFavortie : CheckBox
        var address : TextView
        var target : TextView
        var distance : TextView

        init {
            imgCompany = itemView.findViewById(R.id.imgCompany)
            address = itemView.findViewById(R.id.txtCompanyAddress)
            target = itemView.findViewById(R.id.txtCompanyTarget)
            distance = itemView.findViewById(R.id.txtCompanyDistance)
            chkFavortie = itemView.findViewById(R.id.chkFavorite)
        }
    }
}

data class Company(val img : Int = R.drawable.imgdefaultcompany, var farvorite : Boolean = false
                   , var address : String = "-", var target : String = "-", var distance : String = "-")