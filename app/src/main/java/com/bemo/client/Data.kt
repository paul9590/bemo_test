package com.bemo.client

import android.content.Intent
import java.io.Serializable

const val COMPANY_COMPANY = 1
const val COMPANY_TEXT = 2
const val COMPANY_IMG = 3
const val COMPANY_CAREER = 4
const val COMPANY_REVIEW_AVG = 5
const val COMPANY_REVIEW = 6
const val COMPANY_CATEGORY = 7
const val COMPANY_MAP = 8

interface CompanyInfo {
    val type: Int
    val name: String
}

data class CompanyInfoText(override val name: String = "", val desc: String = ""): CompanyInfo {
    override val type = COMPANY_TEXT
}

data class CompanyInfoImg(override val name: String = "", val img: Int = R.drawable.img_default_company_info): CompanyInfo {
    override val type = COMPANY_IMG
}

data class CompanyInfoCareer(override val name: String = "", val desc: String = "", val img: Int = R.drawable.img_default_company_info_career, val rank: String = ""): CompanyInfo {
    override val type = COMPANY_CAREER
}
data class CompanyInfoReviewAvg(override val name: String = "", val rating: Float = 0.0f): CompanyInfo {
    override val type = COMPANY_REVIEW_AVG
}
data class CompanyInfoReview(override val name: String = "", val img: Int = R.drawable.img_default_my, val desc: String = "", val date: String = "", val rating: Float = 0.0f): CompanyInfo {
    override val type = COMPANY_REVIEW
}

data class Company(
    override val name: String = "",
    val img: Int = R.drawable.img_default_company,
    val isPremium: Boolean = false,
    var favorite: Boolean = false,
    val address: String = "",
    val target: String = "",
    val distance: String = "",
    val utility: ArrayList<String> = ArrayList(),
    var phone: String = "",
    var mail: String = ""
) :
    Serializable, CompanyInfo {
    override val type = COMPANY_COMPANY
}

data class CompanyInfoCategory(override val name: String = "", val name2: String = "", val name3: String = ""): CompanyInfo {
    override val type = COMPANY_CATEGORY
}

data class CompanyInfoMap(val img: Int = R.drawable.img_default_company_info, override val name: String = ""): CompanyInfo {
    override val type = COMPANY_MAP
}

data class HomeCategory(val img : Int, val txt : String)

const val INTENT_LOGOUT = 1
const val INTENT_DELETE = 2

data class InfoIntent(val name: String, val intent: Intent, val flag: Int = 0)

data class Info(val title: String, val body: String)

data class PointInfo(val title: String, val body: String, val img: Int)