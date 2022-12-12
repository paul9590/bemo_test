package com.bemo.client.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.CompanyInfo
import com.bemo.client.databinding.RecyclerviewBinding
import com.bemo.client.recycler.ReviewRecyclerAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ReviewFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val mList = ArrayList<CompanyInfo>()
    private val mAdapter = ReviewRecyclerAdapter(mList)

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

        val mBinding = RecyclerviewBinding.inflate(inflater, container, false).apply {
            viewRecycler.adapter = mAdapter
            viewRecycler.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        }

        return mBinding.root
    }

    fun addList(item: ArrayList<CompanyInfo>) {
        val start = mList.size

        // TODO: 작성한 리뷰 API 호출
        mList += item
        mAdapter.notifyItemRangeInserted(start, mList.size)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CompanyInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}