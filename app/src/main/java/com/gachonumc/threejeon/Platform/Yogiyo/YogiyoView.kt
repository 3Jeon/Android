package com.gachonumc.threejeon.Platform.Yogiyo

interface YogiyoSearchListView {
    fun yogiyoStoreListSuccess(result: Array<YogiyoSearchStoreList>)
    fun yogiyoStroeListFailure(code : Int, message : String)
}