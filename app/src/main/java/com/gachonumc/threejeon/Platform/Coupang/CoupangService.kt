package com.gachonumc.threejeon.Platform.Coupang

import android.util.Log
import android.widget.DatePicker
import com.gachonumc.threejeon.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoupangService {
    private lateinit var coupangSearchListView: CoupangSearchListView

    fun setCoupangSearchService(coupangSearchListView: CoupangSearchListView){
        this.coupangSearchListView = coupangSearchListView
    }

    fun getCoupangSearchService(lat : Double, lng : Double, search : String, sort : String){
        val coupangSearchStoreService = NetworkModule.getInstance()?.create(CoupangRetrofitinterfaces::class.java)
        coupangSearchStoreService?.getCoupangSearchList(lat, lng, search, sort)?.enqueue(object : Callback<CoupangSearch>{
            override fun onResponse(call: Call<CoupangSearch>, response: Response<CoupangSearch>) {
                if (response.isSuccessful && response.code() == 200){
                    val coupangSearch : CoupangSearch = response.body()!!
                    when(coupangSearch.code){
                        1000 -> coupangSearchListView.coupangSearchListSuccess(coupangSearch.result)
                        else -> coupangSearchListView.coupangSearchListFailure(coupangSearch.code, coupangSearch.message)
                    }
                }
            }

            override fun onFailure(call: Call<CoupangSearch>, t: Throwable) {
                Log.d("Server off", "C검색 서버가 꺼져버렸당")
            }

        })
    }













//    private lateinit var coupangStoreListView: CoupangStoreListView
//    fun setCoupangStoreService(coupangStoreListView: CoupangStoreListView){
//        this.coupangStoreListView = coupangStoreListView
//    }
//    fun getCoupangStoreService(category : String, lat : Double, lng : Double){
//        val coupangStoreListService = NetworkModule.getInstance()?.create(CoupangRetrofitinterfaces::class.java)
//        coupangStoreListService?.getCoupangStoreList(category, lat, lng)?.enqueue(object : Callback<CoupangStore>{
//            override fun onResponse(call: Call<CoupangStore>, response: Response<CoupangStore>) {
//                if(response.isSuccessful && response.code() == 200){
//                    val coupangStore : CoupangStore = response.body()!!
//                    when(coupangStore.code){
//                        1000 -> coupangStoreListView.coupangStoreListSuccess(coupangStore.result)
//                        else -> coupangStoreListView.coupangStoreListFailure(coupangStore.code, coupangStore.message)
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<CoupangStore>, t: Throwable) {
//                Log.d("Server off", "C스토어/서버가 꺼져버렸당")
//            }
//
//        })
//    }
}