package com.gachonumc.threejeon.location

import com.gachonumc.threejeon.NetworkModule
import com.gachonumc.threejeon.map.MapInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class LocationService{

    private lateinit var defaultView: DefaultView
    private lateinit var listView: ListView

    fun setDefaultService(defaultView: DefaultView){
        this.defaultView = defaultView
    }
    fun setListService(listView: ListView){
        this.listView = listView
    }

    fun getDefaultService(userId : Int){
        val locationService = NetworkModule.getInstance()?.create(LocationRetrofitinterfaces::class.java)
        locationService?.getDefault(userId)?.enqueue(object : Callback<DefaultResponse> {
            override fun onResponse(
                call: Call<DefaultResponse>,
                response: Response<DefaultResponse>
            ) {
                val defaultResponse : DefaultResponse = response.body()!!
                when(defaultResponse.code){
                    1000 -> defaultView.defaultInfoSuccess(defaultResponse.result)
                    else -> defaultView.defaultInfoFailure(defaultResponse.code, defaultResponse.message)
                }
            }

            override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getListService(userId : Int){
        val locationService = NetworkModule.getInstance()?.create(LocationRetrofitinterfaces::class.java)
        locationService?.getList(userId)?.enqueue(object : Callback<ListResponse>{
            override fun onResponse(call: Call<ListResponse>, response: Response<ListResponse>) {
                val listResponse : ListResponse = response.body()!!
                when(listResponse.code){
                    1000 -> listView.listInfoSuccess(listResponse.result)
                    else -> listView.listInfoFailure(listResponse.code, listResponse.message)
                }
            }

            override fun onFailure(call: Call<ListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

}