package com.bemo.client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerCategoryAdapter(data: ArrayList<HomeCategory>) :
    RecyclerView.Adapter<RecyclerCategoryAdapter.CategoryViewHolder>() {
    private val mData: ArrayList<HomeCategory>

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int):
            RecyclerCategoryAdapter.CategoryViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_category, parent, false)

        return CategoryViewHolder(view)
    }

    // onBindViewHolder : position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item: HomeCategory = mData[position]
        holder.txtCategory.text = item.txt
        holder.imgCategory.setImageResource(item.img)
    }

    // getItemCount : 전체 데이터의 개수를 리턴
    override fun getItemCount(): Int {
        return mData.size
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스
    inner class CategoryViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imgCategory: ImageView
        var txtCategory: TextView

        init {
            imgCategory = itemView.findViewById(R.id.imgCategory)
            txtCategory = itemView.findViewById(R.id.txtCategory)
            imgCategory.setOnClickListener {
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    val item = mData[pos]
                    // 카테고리 클릭 시
                }
            }
        }
    }

    init {
        mData = data
    }
}

data class HomeCategory(val img : Int, val txt : String)