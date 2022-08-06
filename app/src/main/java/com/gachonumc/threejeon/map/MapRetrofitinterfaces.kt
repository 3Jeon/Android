package com.gachonumc.threejeon.map

import retrofit2.Call
import retrofit2.http.*

interface MapRetrofitinterfaces {

    @GET("/map")
    fun getMapDistanceCalculation(
        @Query("goal-lat") goal_lat : Double,
        @Query("goal-lng") lng : Double,
        @Query("start-lat") start_lat : Double,
        @Query("start-lng") start_lng : Double
    ): Call<MapResponse>
}