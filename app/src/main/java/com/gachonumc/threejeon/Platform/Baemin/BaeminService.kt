package com.gachonumc.threejeon.Platform.Baemin

import android.util.Log
import com.gachonumc.threejeon.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BaeminService {
    private lateinit var baeminStoreListView: BaeminStoreListView
    private lateinit var baeminStoreMenuView: BaeminStoreMenuView
    private lateinit var baeminSearchView: BaeminSearchView

    fun setBaeminStoreService(baeminStoreListView: BaeminStoreListView){
        this.baeminStoreListView = baeminStoreListView
    }

    fun setBaeminStoreMenuService(baeminStoreMenuView: BaeminStoreMenuView){
        this.baeminStoreMenuView = baeminStoreMenuView
    }

    fun setBaeminSearchService(baeminSearchView: BaeminSearchView){
        this.baeminSearchView = baeminSearchView
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
                Log.d("Server off", "B스토어/서버가 꺼져버렸당")
            }

        })

    }

    fun getBaeminStoreMenuService(restaurant_id : Int){
        val baeminStoreMenuService = NetworkModule.getInstance()?.create(BaeminRetrofitInterfaces::class.java)
        baeminStoreMenuService?.getBaeminStoreMenuList(restaurant_id)?.enqueue(object : Callback<BaeminStoreMenu>{
            override fun onResponse(call: Call<BaeminStoreMenu>, response: Response<BaeminStoreMenu>) {
                if (response.isSuccessful && response.code() == 200){
                    val baeminStoreMenu: BaeminStoreMenu = response.body()!!

                    when (baeminStoreMenu.code){
                        1000 -> baeminStoreMenuView.baeminStoreMenuSuccess(baeminStoreMenu.result)
                        else -> baeminStoreMenuView.baeminStoreMenuFailure(baeminStoreMenu.code, baeminStoreMenu.message)
                    }


                }
            }

            override fun onFailure(call: Call<BaeminStoreMenu>, t: Throwable) {
                Log.d("Server off", "B스토어/메뉴 서버가 꺼져버렸당")
            }

        })

    }

    fun getBaeminSearchService(items : Int, lat : Double, lng : Double, search : String){
        val baeminSearchService = NetworkModule.getInstance()?.create(BaeminRetrofitInterfaces::class.java)
        baeminSearchService?.getBaeminSearchList(items, lat, lng, search)?.enqueue(object : Callback<BaeminSearch>{
            override fun onResponse(call: Call<BaeminSearch>, response: Response<BaeminSearch>) {
                if (response.isSuccessful && response.code() == 200){
                    val baeminSearch: BaeminSearch = response.body()!!

                    when (baeminSearch.code){
                        1000 -> baeminSearchView.baeminSearchSuccess(baeminSearch.result)
                        else -> baeminSearchView.baeminSearchFailure(baeminSearch.code, baeminSearch.message)
                    }


                }
            }

            override fun onFailure(call: Call<BaeminSearch>, t: Throwable) {
                Log.d("Server off", "B검색/메뉴 서버가 꺼져버렸당")
            }

        })
    }


}