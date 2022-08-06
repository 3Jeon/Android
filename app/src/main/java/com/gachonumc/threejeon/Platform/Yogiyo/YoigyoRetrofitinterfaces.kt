package com.gachonumc.threejeon.Platform.Yogiyo

import retrofit2.Call
import retrofit2.http.*

interface YoigyoRetrofitinterfaces {

    @GET("/yogiyo/search-restaurants")
    fun getYogiyoSearchList(
        @Query("items") items: Int,
        @Query("lat") lat : Double,
        @Query("lng") lng : Double,
        @Query("page") page : Int,
        @Query("search") search : String,
        @Query("sort") sort : String
    ): Call<YogiyoSearch>
}