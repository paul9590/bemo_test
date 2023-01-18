package com.bemo.client.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bemo.client.Company
import com.bemo.client.R
import kotlin.collections.ArrayList

enum class Request {
    COMPANY_RESULT, COMPANY_RECENT, COMPANY_FAVORITE
}

class CompanyViewModel(private val request: Request): ViewModel() {
    private val _companyList = MutableLiveData<ArrayList<Company>>()
    val companyList: MutableLiveData<ArrayList<Company>>
        get() = _companyList

    init {
        _companyList.value = getCompanyList()
    }

    // TODO: 최근 본 업체 정보 API 호출
    // TODO: 검색 결과 업체 정보 API 호출
    // TODO: 찜 목록 업체 정보 API 호출

    private fun getCompanyList(): ArrayList<Company> {
        return when(request) {
                Request.COMPANY_RESULT -> tmpCompanyList()
                Request.COMPANY_RECENT -> tmpCompanyList2()
                Request.COMPANY_FAVORITE -> tmpCompanyList()
            }
    }

    private fun tmpCompanyList(): ArrayList<Company> {
        return ArrayList<Company>().apply {
            add(Company("송수학 학원", R.drawable.img_place1, true, true, "경기도 남양주시 도농동", "10대", distance = "1km"))
            add(Company("구주이베 학원", R.drawable.img_place2, true, true, "경기도 남양주시 다산동","10대", distance = "1km"))
            add(Company("윙 스피킹 강남",R.drawable.img_place3,true, true, "경기도 구리시 벌말로", "10대", distance = "1km"))
            add(Company("BIS어학원 서초 캠퍼스", R.drawable.img_place4, true, true, "경기도 남양주시 평내호평동", "10대", distance = "1km"))
        }
    }
    private fun tmpCompanyList2(): ArrayList<Company> {
        return ArrayList<Company>().apply {
            add(Company("송수학 학원", R.drawable.img_place1, true, true, "경기도 남양주시 도농동", "10대", distance = "1km"))
            add(Company("구주이베 학원", R.drawable.img_place2, true, true, "경기도 남양주시 다산동","10대", distance = "1km"))
            add(Company("윙 스피킹 강남",R.drawable.img_place3,true, true, "경기도 구리시 벌말로", "10대", distance = "1km"))
            add(Company("BIS어학원 서초 캠퍼스", R.drawable.img_place4, true, true, "경기도 남양주시 평내호평동", "10대", distance = "1km"))
            add(Company())
        }
    }
}
