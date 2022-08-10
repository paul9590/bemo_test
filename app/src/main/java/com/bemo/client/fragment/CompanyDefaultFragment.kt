package com.bemo.client.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bemo.client.Company
import com.bemo.client.R
import com.bemo.client.databinding.FragmentCompanyDefaultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CompanyDefaultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompanyDefaultFragment : Fragment() {
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
        val mBinding = FragmentCompanyDefaultBinding.inflate(inflater, container, false)

        val company = arguments?.getSerializable("company") as Company

        setCompanyInfo(company, mBinding)

        return mBinding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CompanyDefaultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CompanyDefaultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setCompanyInfo(company : Company, mBinding : FragmentCompanyDefaultBinding) {
        mBinding.imgCompany.setImageResource(company.img)
        mBinding.txtCompanyName.text = company.name
        mBinding.txtCompanyAddress.text = company.address
        mBinding.txtCompanyTarget.text = company.target
        mBinding.txtCompanyDistance.text = company.distance

        if(company.shuttle) {
            mBinding.txtCompanyShuttle.text = "셔틀버스 있음"
            mBinding.txtCompanyShuttle.setTextColor(resources.getColor(R.color.blue))
        }else {
            mBinding.txtCompanyShuttle.text = "셔틀버스 없음"
            mBinding.txtCompanyShuttle.setTextColor(resources.getColor(R.color.red))
        }
        val sb = StringBuilder()
        for(i in 0 .. 100) {
            sb.append("가나다라마바사아자차카타파하")
        }

        mBinding.viewCompanyDescribe.txtCompanyInfoTxt.text = "상세 설명"
        mBinding.viewCompanyDescribe.txtCompanyInfo.text = sb.toString()
    }
}