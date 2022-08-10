package com.bemo.client

import java.io.Serializable

const val TYPE_COMPANY = 1
const val TYPE_TEXT = 2
const val TYPE_IMG = 3
const val TYPE_CAREER = 4
const val TYPE_REVIEW_AVG = 5
const val TYPE_REVIEW = 6
const val TYPE_CATEGORY = 7
const val TYPE_MAP = 8

interface CompanyInfo {
    val type: Int
    val name: String
}

data class CompanyInfoText(override val name: String = "", val desc: String = ""): CompanyInfo {
    override val type = TYPE_TEXT
}

data class CompanyInfoImg(override val name: String = "", val img: Int = 0): CompanyInfo {
    override val type = TYPE_IMG
}

data class CompanyInfoCareer(override val name: String = "", val desc: String = "", val img: Int = 0, val rank: String = ""): CompanyInfo {
    override val type = TYPE_CAREER
}
data class CompanyInfoReviewAvg(override val name: String = "", val rating: Float = 0.0f): CompanyInfo {
    override val type = TYPE_REVIEW_AVG
}
data class CompanyInfoReview(override val name: String = "", val img: Int = 0, val desc: String = "", val date: String = "", val rating: Float = 0.0f): CompanyInfo {
    override val type = TYPE_REVIEW
}

data class Company(
    override val name: String = "",
    val img: Int = R.drawable.imgdefaultcompany,
    var farvorite: Boolean = false,
    var address: String = "",
    var target: String = "",
    var distance: String = "",
    var shuttle: Boolean = false
) :
    Serializable, CompanyInfo {
    override val type = TYPE_COMPANY
}

data class CompanyInfoCategory(override val name: String = "", val name2: String = "", val name3: String = ""): CompanyInfo {
    override val type = TYPE_CATEGORY
}

data class CompanyInfoMap(val img: Int = 0, override val name: String = ""): CompanyInfo {
    override val type = TYPE_MAP
}