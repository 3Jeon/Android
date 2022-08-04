package com.gachonumc.threejeon

import android.net.Network
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BaeminService {
    private lateinit var baeminStoreListView: BaeminStoreListView
    private lateinit var baeminStoreMenuView: BaeminStoreMenuView

    fun setBaeminStoreService(baeminStoreListView: BaeminStoreListView){
        this.baeminStoreListView = baeminStoreListView
    }

    fun setBaeminStoreMenuService(baeminStoreMenuView: BaeminStoreMenuView){
        this.baeminStoreMenuView = baeminStoreMenuView
    }

    //retrofit 만듬
    fun getBaeminStoreService(category : String, lat : Double, lng : Double){
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
                Log.d("Server off", "B스토어 서버가 꺼져버렸당")
            }

        })

    }

    fun getBaeminStoreMenuService(restaurant_id : Int){
        val baeminStoreMenuService = NetworkModule.getInstance()?.create(BaeminRetrofitInterfaces::class.java)
        baeminStoreMenuService?.getBaeminStoreMenuList(restaurant_id)?.enqueue(object : Callback<BaeminStoreMenu>{
            override fun onResponse(call: Call<BaeminStoreMenu>, response: Response<BaeminStoreMenu>) {
                if (response.isSuccessful && response.code() == 200){
                    val baeminStoreMenu: BaeminStoreMenu = response.body()!!
                    /*
                    when (baeminStoreMenu.code){
                        1000 -> baeminStoreListView.baeminStoreListSuccess(baeminStoreMenu.result)
                        else -> baeminStoreListView.baeminStoreListFailure(baeminStoreMenu.code, baeminStoreMenu.message)
                    }

                     */
                }
            }

            override fun onFailure(call: Call<BaeminStoreMenu>, t: Throwable) {
                Log.d("Server off", "B스토어/메뉴 서버가 꺼져버렸당")
            }

        })

    }


}