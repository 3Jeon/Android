package com.gachonumc.threejeon

    interface BaeminStoreListView{
        fun baeminStoreListSuccess(result: Array<BaeminStoreList>)
        fun baeminStoreListFailure(code : Int, message: String)
    }

interface BaeminStoreMenuView{
    fun baeminStoreMenuSuccess(result: Array<BaeminStoreMenuList>)
    fun baeminStoreMenuFailure(code : Int, message: String)
}
