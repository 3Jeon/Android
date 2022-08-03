package com.gachonumc.threejeon

    interface BaeminStoreListView{
        fun baeminStoreListSuccess(result: Array<BaeminStoreList>)
        fun baeminStoreListFailure(code : Int, message: String)
    }
