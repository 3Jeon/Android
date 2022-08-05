package com.gachonumc.threejeon.Platform.Coupang

import android.util.Log
import com.gachonumc.threejeon.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoupangService {
    private lateinit var coupangStoreListView: CoupangStoreListView

    fun setCoupangStoreService(coupangStoreListView: CoupangStoreListView){
        this.coupangStoreListView = coupangStoreListView
    }


    fun getCoupangStoreService(category : String, lat : Double, lng : Double){
        val coupangStoreListService = NetworkModule.getInstance()?.create(CoupangRetrofitinterfaces::class.java)
        coupangStoreListService?.getCoupangStoreList(category, lat, lng)?.enqueue(object : Callback<CoupangStore>{
            override fun onResponse(call: Call<CoupangStore>, response: Response<CoupangStore>) {
                if(response.isSuccessful && response.code() == 200){
                    val coupangStore : CoupangStore = response.body()!!
                    when(coupangStore.code){
                        1000 -> coupangStoreListView.coupangStoreListSuccess(coupangStore.result)
                        else -> coupangStoreListView.coupangStoreListFailure(coupangStore.code, coupangStore.message)
                    }
                }
            }

            override fun onFailure(call: Call<CoupangStore>, t: Throwable) {
                Log.d("Server off", "C스토어/서버가 꺼져버렸당")
            }

        })
    }
}