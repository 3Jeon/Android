package com.gachonumc.threejeon.map

import android.location.Location
import android.util.Log
import com.gachonumc.threejeon.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapService {

    private lateinit var mapView : MapView
    private lateinit var geoView : GeoView

    fun setGeoService(geoView: GeoView){
        this.geoView = geoView
    }

    fun setMapService(mapView: MapView){
        this.mapView = mapView
    }

    fun getMapService(goal_lat : Double, gaol_lng : Double, start_lat : Double, start_lng : Double){
        val mapService = NetworkModule.getInstance()?.create(MapRetrofitinterfaces::class.java)
        mapService?.getMapDistanceCalculation(goal_lat, gaol_lng, start_lat, start_lng)?.enqueue(object : Callback<MapResponse>{
            override fun onResponse(call: Call<MapResponse>, response: Response<MapResponse>) {
                val mapResponse : MapResponse = response.body()!!
                when(mapResponse.code){
                    1000 -> mapView.mapInfoSuccess(mapResponse.result)
                    else -> mapView.mapInfoFailure(mapResponse.code, mapResponse.message)
                }
            }

            override fun onFailure(call: Call<MapResponse>, t: Throwable) {
                Log.d("Server off", "N지도 서버가 꺼져버렸당")
            }

        })
    }

    fun getGeoService(location: String, userId: Int){
        val geoService = NetworkModule.getInstance()?.create(MapRetrofitinterfaces::class.java)
        geoService?.getMapGeocode(location, userId)?.enqueue(object : Callback<GeocodeResponse>{
            override fun onResponse(
                call: Call<GeocodeResponse>,
                response: Response<GeocodeResponse>
            ) {
                val geocodeResponse : GeocodeResponse = response.body()!!
                when(geocodeResponse.code){
                    1000 -> geoView.geoInfoSuccess(geocodeResponse.result)
                    else -> geoView.geoInfoFailure(geocodeResponse.code, geocodeResponse.message)
                }
            }

            override fun onFailure(call: Call<GeocodeResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}