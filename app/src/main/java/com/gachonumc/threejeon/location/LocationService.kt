package com.gachonumc.threejeon.location

import android.net.Network
import com.gachonumc.threejeon.NetworkModule
import com.gachonumc.threejeon.map.MapInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class LocationService{

    private lateinit var defaultView: DefaultView
    private lateinit var listView: ListView
    private lateinit var locaAddView: LocaAddView
    private lateinit var locaChangeView : LocaChangeView
    private lateinit var locaDeleteView: LocaDeleteView

    fun setDefaultService(defaultView: DefaultView){
        this.defaultView = defaultView
    }
    fun setListService(listView: ListView){
        this.listView = listView
    }
    fun setLocaAddService(locaAddView: LocaAddView){
        this.locaAddView = locaAddView
    }
    fun setLocaChangeService(locaChangeView: LocaChangeView){
        this.locaChangeView = locaChangeView
    }
    fun setLocaDeleteService(locaDeleteView: LocaDeleteView){
        this.locaDeleteView = locaDeleteView
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

    fun getLocaAddService(postUserLocationReq: locaAdd, userId: Int){
        val locaAddService = NetworkModule.getInstance()?.create(LocationRetrofitinterfaces::class.java)
        locaAddService?.getAddLocation(postUserLocationReq, userId)?.enqueue(object : Callback<AddResponse>{
            override fun onResponse(call: Call<AddResponse>, response: Response<AddResponse>) {
                val locaAddResponse : AddResponse = response.body()!!
                when(locaAddResponse.code){
                    1000 -> locaAddView.locaAddSuccess(locaAddResponse.result)
                    else -> locaAddView.locaAddFailure(locaAddResponse.code, locaAddResponse.message)
                }
            }

            override fun onFailure(call: Call<AddResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getLocaChangeService(postUserLocationReq: locaAdd, userId: Int){
        val locaChangeService = NetworkModule.getInstance()?.create(LocationRetrofitinterfaces::class.java)
        locaChangeService?.getChangeLocation(postUserLocationReq, userId)?.enqueue(object : Callback<ChangeLocaResponse>{
            override fun onResponse(
                call: Call<ChangeLocaResponse>,
                response: Response<ChangeLocaResponse>
            ) {
                val locaChangeResponse : ChangeLocaResponse = response.body()!!
                when(locaChangeResponse.code){
                    1000 -> locaChangeView.locaChangeSuccess(locaChangeResponse.result)
                    else -> locaChangeView.locaChangeFailure(locaChangeResponse.code, locaChangeResponse.message)
                }
            }

            override fun onFailure(call: Call<ChangeLocaResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getLocaDeleteService(locationId : Int){
        val locaDeleteService = NetworkModule.getInstance()?.create(LocationRetrofitinterfaces::class.java)
        locaDeleteService?.getDeleteLocation(locationId)?.enqueue(object : Callback<DeleteChangeResponse>{
            override fun onResponse(
                call: Call<DeleteChangeResponse>,
                response: Response<DeleteChangeResponse>
            ) {
                val locaDeleteResponse : DeleteChangeResponse = response.body()!!
                when(locaDeleteResponse.code){
                    1000 -> locaDeleteView.locaDeleteSuccess(locaDeleteResponse.result)
                    else -> locaDeleteView.locaDeleteFailure(locaDeleteResponse.code, locaDeleteResponse.message)
                }
            }

            override fun onFailure(call: Call<DeleteChangeResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}