package com.gachonumc.threejeon.Platform.Yogiyo

import android.util.Log
import com.gachonumc.threejeon.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class YogiyoService {

    private lateinit var yogiyoSearchListView: YogiyoSearchListView

    fun setYogiyoSearchService(yogiyoSearchListView: YogiyoSearchListView){
        this.yogiyoSearchListView = yogiyoSearchListView
    }

    fun getYogiyoSearchService(items : Int, lat: Double, lng: Double, page : Int, search : String, sort : String){
        val yogiyoSearchStoreService = NetworkModule.getInstance()?.create(YoigyoRetrofitinterfaces:: class.java)
        yogiyoSearchStoreService?.getYogiyoSearchList(items, lat, lng, page, search, sort)?.enqueue(object : Callback<YogiyoSearch>{
            override fun onResponse(call: Call<YogiyoSearch>, response: Response<YogiyoSearch>) {
                if(response.isSuccessful && response.code() == 200){
                    val yogiyoSearch : YogiyoSearch = response.body()!!
                    when(yogiyoSearch.code){
                        1000 -> yogiyoSearchListView.yogiyoStoreListSuccess(yogiyoSearch.result)
                        else -> yogiyoSearchListView.yogiyoStroeListFailure(yogiyoSearch.code, yogiyoSearch.message)
                    }
                }
            }

            override fun onFailure(call: Call<YogiyoSearch>, t: Throwable) {
                Log.d("Server off", "Y검색 서버가 꺼져버렸당")
            }

        })
    }

}