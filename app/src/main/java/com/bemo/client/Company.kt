package com.bemo.client

import java.io.Serializable


data class Company(val name : String = "-", val img : Int = R.drawable.imgdefaultcompany, var farvorite : Boolean = false
                   , var address : String = "-", var target : String = "-", var distance : String = "-", var shuttle : Boolean = false) :
    Serializable