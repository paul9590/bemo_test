package com.bemo.client

const val TYPE_TEXT = 1
const val TYPE_IMG = 2
const val TYPE_CAREER = 3

data class CompanyInfo(
    val type: Int = TYPE_TEXT,
    val name: String = "설명",
    val img: Int = 0,
    val desc: String = "",
    val rank: String = ""
)