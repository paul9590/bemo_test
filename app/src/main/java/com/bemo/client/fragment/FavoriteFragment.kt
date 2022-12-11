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
import com.bemo.client.databinding.RecyclerviewBinding
import com.bemo.client.recycler.CompanyRecyclerAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FavoriteFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mBinding: RecyclerviewBinding
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
        mBinding = RecyclerviewBinding.inflate(inflater, container, false)

        setAdapter()

        return mBinding.root
    }

    private fun setAdapter() {
        mBinding.viewRecycler.adapter = mAdapter
        mBinding.viewRecycler.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }

    private fun addList() {

        // TODO: 찜 목록 API 호출
        val start = mList.size
        mList += getFavoriteList()
        mAdapter.notifyItemRangeInserted(start, mList.size)
    }

    private fun getFavoriteList(): ArrayList<Company> {
        val list = ArrayList<Company>()
        repeat(5) {
            list.add(Company(
                name = "업체 이름",
                img = R.drawable.img_place1,
                isPremium = true,
                favorite = true,
                address = "경기도 남양주시 도농동",
                target = "10대",
                distance = "1km"
            ))
        }
        return list
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavoriteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}