package com.bemo.client.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bemo.client.MyViewAdapter
import com.bemo.client.databinding.FragmentMyBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyFragment : Fragment() {
    // TODO: Rename and change types of parameters
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
        // Inflate the layout for this fragment
        val mBinding = FragmentMyBinding.inflate(inflater, container, false)
        // 로그인 정보 불러오기
        mBinding.txtMy.text = "김종민님,\n안녕하세요!!"
        val adapter = MyViewAdapter(childFragmentManager)
        mBinding.pagerMy.adapter = adapter
        mBinding.tabMy.setupWithViewPager(mBinding.pagerMy)

        setTab(mBinding)

        return mBinding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setTab(mBinding : FragmentMyBinding) {
        val texts = arrayOf("최근 본", "찜")

        for(i in texts.indices) {
            val tab = mBinding.tabMy.getTabAt(i)!!
            tab.text = texts[i]
        }
    }
}