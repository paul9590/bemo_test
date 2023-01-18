package com.bemo.client.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bemo.client.databinding.RecyclerViewBinding
import com.bemo.client.recycler.CompanyRecyclerAdapter
import com.bemo.client.viewmodel.CompanyViewModel
import com.bemo.client.viewmodel.Request

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RecentFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val mAdapter = CompanyRecyclerAdapter()
    private val viewModel = CompanyViewModel(Request.COMPANY_RECENT)

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

        val mBinding = RecyclerViewBinding.inflate(inflater, container, false).apply {
            viewRecycler.adapter = mAdapter
            viewRecycler.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        }
        mBinding.viewModel = viewModel
        mBinding.lifecycleOwner = this

        viewModel.companyList.observe(viewLifecycleOwner) {
            viewModel.companyList.value?.let { mAdapter.setData(it) }
        }

        return mBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}