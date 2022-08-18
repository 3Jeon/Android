package com.gachonumc.threejeon.location

interface DefaultView {
    fun defaultInfoSuccess(result: DefaultInfo)
    fun defaultInfoFailure(code: Int, messgae : String)
}

interface ListView{
    fun listInfoSuccess(result : ListInfo)
    fun listInfoFailure(code: Int, messgae: String)
}

interface LocaAddView{
    fun locaAddSuccess(result : String)
    fun locaAddFailure(code: Int, messgae: String)
}