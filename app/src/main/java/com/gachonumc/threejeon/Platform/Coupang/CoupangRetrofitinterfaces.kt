package com.gachonumc.threejeon.Platform.Coupang

import retrofit2.Call
import retrofit2.http.*

interface CoupangRetrofitinterfaces {

//    @GET("/coupang/restaurant")
//    fun getCoupangStoreList(
//        @Query("category") category: String,
//        @Query("lat") lat: Double,
//        @Query("lng") lng: Double
//    ): Call<CoupangStore>

    @GET("/coupang/search-restaurants")
    fun getCoupangSearchList(
        @Query("lat") lat : Double,
        @Query("lng") lng : Double,
        @Query("search") search : String,
        @Query("sort") sort : String
    ): Call<CoupangSearch>
}