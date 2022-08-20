package com.gachonumc.threejeon.location

interface DefaultView {
    fun defaultInfoSuccess(result: DefaultInfo)
    fun defaultInfoFailure(code: Int, messgae : String)
}

interface ListView{
    fun listInfoSuccess(result : ListInfo)
    fun listInfoFailure(code: Int, messgae: String)
}

interface LocaAddView {
    fun locaAddSuccess(result: String)
    fun locaAddFailure(code: Int, messgae: String)
}

interface LocaChangeView{
    fun locaChangeSuccess(result : LocaChangeInfo)
    fun locaChangeFailure(code: Int, messgae: String)
}

interface LocaDeleteView{
    fun locaDeleteSuccess(result : String)
    fun locaDeleteFailure(code: Int, messgae: String)
}