package com.bemo.client.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.PointInfo
import com.bemo.client.databinding.RecyclerListBinding
import com.bemo.client.recycler.PointRecyclerAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PointFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mBinding: RecyclerListBinding
    private val mList = ArrayList<PointInfo>()
    private val mAdapter = PointRecyclerAdapter(mList)

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
        mBinding = RecyclerListBinding.inflate(inflater, container, false)
        setAdapter()
        return mBinding.root
    }

    private fun setAdapter() {
        mBinding.viewList.adapter = mAdapter
        mBinding.viewList.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }

    fun setList(newList: ArrayList<PointInfo>) {
        mList.clear()
        mList += newList
        mAdapter.notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PointFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}