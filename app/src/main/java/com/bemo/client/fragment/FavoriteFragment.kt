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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteFragment : Fragment() {
    // TODO: Rename and change types of parameters
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
        // Inflate the layout for this fragment
        mBinding = RecyclerviewBinding.inflate(inflater, container, false)

        setAdapter()

        return mBinding.root
    }

    private fun setAdapter() {
        mBinding.viewRecycler.adapter = mAdapter
        mBinding.viewRecycler.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }

    private fun addList() {
        val start = mList.size
        mList += getFavoriteList()
        mAdapter.notifyItemRangeInserted(start, mList.size)
    }

    private fun getFavoriteList(): ArrayList<Company> {
        val list = ArrayList<Company>()
        repeat(5) {
            list.add(Company(
                name = "업체 이름",
                img = R.drawable.img_category1,
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavoriteFragment.
         */
        // TODO: Rename and change types and number of parameters
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