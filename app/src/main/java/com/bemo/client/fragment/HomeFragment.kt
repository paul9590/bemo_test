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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mBinding: FragmentHomeBinding

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
        // Inflate the layout for this fragment
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)

        setCategoryTab()

        return mBinding.root
    }

    private fun setCategoryTab() {
        val lessonList = ArrayList<HomeCategory>()
        lessonList.add(HomeCategory(R.drawable.img_lesson1, "교과목"))
        lessonList.add(HomeCategory(R.drawable.img_lesson2, "예술"))
        lessonList.add(HomeCategory(R.drawable.img_lesson3, "운동"))
        lessonList.add(HomeCategory(R.drawable.img_lesson4, "자격증"))
        lessonList.add(HomeCategory(R.drawable.img_lesson5, "취미"))
        lessonList.add(HomeCategory(R.drawable.img_lesson6, "유학"))
        lessonList.add(HomeCategory(R.drawable.img_lesson7, "입시"))
        mBinding.viewCategory1.adapter = CategoryRecyclerAdapter(lessonList)
        mBinding.viewCategory1.layoutManager = GridLayoutManager(activity, 4)

        val placeList = ArrayList<HomeCategory>()
        placeList.add(HomeCategory(R.drawable.img_place1, "독서실 / 스터디"))
        placeList.add(HomeCategory(R.drawable.img_place2, "유치원"))
        placeList.add(HomeCategory(R.drawable.img_place3, "헬스장"))
        mBinding.viewCategory2.adapter = CategoryRecyclerAdapter(placeList)
        mBinding.viewCategory2.layoutManager = GridLayoutManager(activity, 4)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
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