package com.gachonumc.threejeon.Coupang

interface CoupangStoreListView{
    fun coupangStoreListSuccess(result: Array<CoupangStoreList>)
    fun coupangStoreListFailure(code : Int, message : String)
}