package com.bemo.client.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.bemo.client.HomeCategory
import com.bemo.client.R
import com.bemo.client.recycler.CategoryRecyclerAdapter
import com.bemo.client.databinding.FragmentHomeBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val mBinding = FragmentHomeBinding.inflate(inflater, container, false).apply {

            // TODO: 카테고리 목록 API 호출
            viewCategory1.adapter = CategoryRecyclerAdapter(getCategoryLesson())
            viewCategory2.adapter = CategoryRecyclerAdapter(getCategoryPlace())
            viewCategory1.layoutManager = GridLayoutManager(activity, 4)
            viewCategory2.layoutManager = GridLayoutManager(activity, 4)
        }

        return mBinding.root
    }

    private fun getCategoryLesson(): ArrayList<HomeCategory> {
        return ArrayList<HomeCategory>().apply {
            add(HomeCategory(R.drawable.img_lesson1, "교과목"))
            add(HomeCategory(R.drawable.img_lesson2, "예술"))
            add(HomeCategory(R.drawable.img_lesson3, "운동"))
            add(HomeCategory(R.drawable.img_lesson4, "자격증"))
            add(HomeCategory(R.drawable.img_lesson5, "취미"))
            add(HomeCategory(R.drawable.img_lesson6, "유학"))
            add(HomeCategory(R.drawable.img_lesson7, "입시"))
        }
    }

    private fun getCategoryPlace(): ArrayList<HomeCategory> {
        return ArrayList<HomeCategory>().apply {
            add(HomeCategory(R.drawable.img_place1, "독서실"))
            add(HomeCategory(R.drawable.img_place2, "유치원"))
            add(HomeCategory(R.drawable.img_place3, "휘트니스"))
            add(HomeCategory(R.drawable.img_place4, "레저"))
            add(HomeCategory(R.drawable.img_place5, "도서관"))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}