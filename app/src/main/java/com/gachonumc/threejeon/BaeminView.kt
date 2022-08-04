package com.gachonumc.threejeon

    interface BaeminStoreListView{
        fun baeminStoreListSuccess(result: Array<BaeminStoreList>)
        fun baeminStoreListFailure(code : Int, message: String)
    }

interface BaeminStoreMenuView{
    fun baeminStoreMenuSuccess(result: BaeminStoreMenuList)
    fun baeminStoreMenuFailure(code : Int, message: String)
}

interface BaeminSearchView{
    fun baeminSearchSuccess(result: BaeminSearchStoreList)
    fun baeminSearchFailure(code : Int, message: String)
}