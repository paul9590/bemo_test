package com.bemo.client.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.Company
import com.bemo.client.R
import com.bemo.client.activity.MainActivity
import com.bemo.client.recycler.CompanyRecyclerAdapter
import com.bemo.client.databinding.FragmentResultBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ResultFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mBinding: FragmentResultBinding
    private val mList = ArrayList<Company>()
    private val mAdapter = CompanyRecyclerAdapter(mList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        addList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentResultBinding.inflate(inflater, container, false)

        setAdapter()

        mBinding.imbBack.setOnClickListener {
            (activity as MainActivity).viewHome()
        }

        return mBinding.root
    }

    private fun setAdapter() {
        mBinding.viewCompany.adapter = mAdapter
        mBinding.viewCompany.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }

    private fun addList() {
        val start = mList.size
        mList += getResultList()
        mAdapter.notifyItemRangeInserted(start, mList.size)
    }


    private fun getResultList(): ArrayList<Company> {
        val list = ArrayList<Company>()

        list.add(Company("송수학 학원", R.drawable.img_place1, true, true, "경기도 남양주시 도농동", "10대", distance = "1km", shuttle = true))
        list.add(Company("구주이베 학원", R.drawable.img_place2, true, true, "경기도 남양주시 다산동", "10대", distance = "1km", shuttle = true))
        list.add(Company("윙 스피킹 강남", R.drawable.img_place3, true, true, "경기도 구리시 벌말로", "10대", distance = "1km", shuttle = true))
        list.add(Company("BIS어학원 서초 캠퍼스", R.drawable.img_place4, true, true, "경기도 남양주시 평내호평동", "10대", distance = "1km", shuttle = true))
        list.add(Company("이안어학원 서초브랜치", R.drawable.img_lesson4, true, true, "경기도 의정부시 의정부 1동", "10대", distance = "1km", shuttle = true))
        list.add(Company("와이즈만 영재교육 서초센터", R.drawable.img_lesson6, true, true, "경기도 의정부시 녹양동", "10대", distance = "1km", shuttle = true))
        list.add(Company("생각하는 황서 서초 학원", R.drawable.img_lesson1, true, true, "경기도 동두천시 벌말로", "10대", distance = "1km", shuttle = true))
        list.add(Company())
        return list
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}