package com.gachonumc.threejeon.Baemin

import retrofit2.Call
import retrofit2.http.*

interface BaeminRetrofitInterfaces {

    @GET("/baemin/restaurant")
    fun getBaeminStoreList(
        @Query("category") category: String,
        @Query("lat") lat: Double,
        @Query("lng") lng: Double
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
        @Query("search") search : String
    ): Call<BaeminSearch>
}