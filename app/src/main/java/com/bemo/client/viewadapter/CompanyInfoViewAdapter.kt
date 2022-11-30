package com.bemo.client.viewadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bemo.client.*
import com.bemo.client.fragment.CompanyInfoFragment

class CompanyInfoViewAdapter(company: Company, fm: FragmentManager?) : FragmentPagerAdapter(fm!!,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
){
    private val fragList = ArrayList<CompanyInfoFragment>()

    init {
        fragList.add(CompanyInfoFragment())
        fragList.add(CompanyInfoFragment())
        fragList.add(CompanyInfoFragment())
        fragList.add(CompanyInfoFragment())
        fragList.add(CompanyInfoFragment())

        setCompanyInfo(company)
    }

    override fun getCount(): Int {
        return fragList.size
    }

    override fun getItem(p0: Int): Fragment = fragList[p0]

    private fun setCompanyInfo(company: Company) {
        setCompanyDefault(company, fragList[0])
        setOther()
        setCompanyReview(fragList[4])
    }

    private fun setCompanyDefault(company: Company, frag: CompanyInfoFragment) {
        val list = ArrayList<CompanyInfo>()
        list.add(company)
        list.add(CompanyInfoCategory("업체", "수학", "영어"))

        val sb = StringBuilder()
        repeat(100) {
            sb.append("가나다라마바사아자차카타파하")
        }

        list.add(CompanyInfoText("상세 설명", desc = sb.toString()))
        list.add(CompanyInfoMap(R.drawable.img_default_my))
        frag.addList(list)
    }

    private fun setCompanyReview(frag: CompanyInfoFragment) {
        val list = ArrayList<CompanyInfo>()
        list.add(CompanyInfoReviewAvg("리뷰(13)", 4.1f))
        repeat(5) {
            list.add(CompanyInfoReview("김종민", R.drawable.img_default_my, "완전 좋아요!!", "2022/08/11", 3.8f))
        }
        frag.addList(list)
    }

    private fun setOther() {

        val list = ArrayList<CompanyInfo>()
        val sb = StringBuilder()
        repeat(100) {
            sb.append("가나다라마바사아자차카타파하")
        }
        list.add(CompanyInfoImg("이미지"))
        list.add(CompanyInfoText("상세 설명", desc = "안녕하세요"))
        list.add(CompanyInfoImg("이미지"))
        list.add(CompanyInfoText("상세 설명", desc = sb.toString()))
        fragList[1].addList(list)
        fragList[2].addList(list)

        val list3 = ArrayList<CompanyInfo>()
        list3.add(CompanyInfoCareer("김종민", "공동대표", R.drawable.img_default_company_info_career, "대표"))
        list3.add(CompanyInfoCareer("서예빈", "공동대표", R.drawable.img_default_company_info_career, "대표"))
        list3.add(CompanyInfoCareer("황성현", "?", R.drawable.img_default_company_info_career, "개발자"))
        fragList[3].addList(list3)
    }
}