package com.gachonumc.threejeon

import android.net.Network
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BaeminService {
    private lateinit var baeminStoreListView: BaeminStoreListView

    fun setBaeminService(baeminStoreListView: BaeminStoreListView){
        this.baeminStoreListView = baeminStoreListView
    }

    //retrofit 만듬
    fun getBaeminService(category : String, lat : Double, lng : Double){
        val baeminStoreListService = NetworkModule.getInstance()?.create(BaeminRetrofitInterfaces::class.java)
        baeminStoreListService?.getBaeminStoreList(category, lat, lng)?.enqueue(object: Callback<BaeminStore> {
            override fun onResponse(call: Call<BaeminStore>, response: Response<BaeminStore>) {
                if (response.isSuccessful && response.code() == 200){
                    val baeminStore: BaeminStore = response.body()!!
                    when (baeminStore.code){
                        1000 -> baeminStoreListView.baeminStoreListSuccess(baeminStore.result)
                        else -> baeminStoreListView.baeminStoreListFailure(baeminStore.code, baeminStore.message)
                    }
                }
            }

            override fun onFailure(call: Call<BaeminStore>, t: Throwable) {
                Log.d("Server off", "서버가 꺼져버렸당")
            }

        })

    }


}