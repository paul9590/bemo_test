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

class CompanyRecyclerAdapter(data: ArrayList<Company>) :
    RecyclerView.Adapter<CompanyRecyclerAdapter.CompanyViewHolder>(){
    private val mData: ArrayList<Company>
    private lateinit var context : Context

    init {
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {

        context = parent.context
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_company, parent, false)

        return CompanyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        val item: Company = mData[position]
        holder.chkFavorite.isChecked = item.farvorite
        holder.chkFavorite.setOnClickListener {
            // 찜 목록 클릭 시 서버 통신
            item.farvorite = !holder.chkFavorite.isChecked
        }
        holder.imgCompany.setImageResource(item.img)
        holder.name.text = item.name
        holder.address.text = item.address
        holder.target.text = item.target
        holder.distance.text = item.distance

        // 업체 상세 페이지로 이동
        holder.itemView.setOnClickListener {
            val intent = Intent(context, CompanyActivity::class.java)
            intent.putExtra("company", item)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = mData.size

    inner class CompanyViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name : TextView
        var imgCompany : ImageView
        var chkFavorite : CheckBox
        var address : TextView
        var target : TextView
        var distance : TextView

        init {
            name = itemView.findViewById(R.id.txtCompany1)
            imgCompany = itemView.findViewById(R.id.imgCompany)
            address = itemView.findViewById(R.id.txtCompanyAddress)
            target = itemView.findViewById(R.id.txtCompanyTarget)
            distance = itemView.findViewById(R.id.txtCompanyDistance)
            chkFavorite = itemView.findViewById(R.id.chkFavorite)
        }
    }
}