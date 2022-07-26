package com.gachonumc.threejeon.Platform.Baemin

import retrofit2.Call
import retrofit2.http.*

interface BaeminRetrofitInterfaces {

    @GET("/baemin/restaurant")
    fun getBaeminStoreList(
        @Query("category") category: String,
        @Query("lat") lat: Double,
        @Query("lng") lng: Double,
        @Query("sort") sort : String
    ): Call<BaeminStore>

    @GET("/baemin/{restaurant-id}/menu")
    fun getBaeminStoreMenuList(
        @Path("restaurant-id") restaurant_id : Int
    ): Call<BaeminStoreMenu>

    @GET("/beamin/search-restaurants")
    fun getBaeminSearchList(
        @Query("items") items : Int,
        @Query("lat") lat : Double,
        @Query("lng") lng : Double,
        @Query("search") search : String,
        @Query("sort") sort : String
    ): Call<BaeminSearch>
}