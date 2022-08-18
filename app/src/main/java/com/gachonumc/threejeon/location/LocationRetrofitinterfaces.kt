package com.gachonumc.threejeon.location

import retrofit2.Call
import retrofit2.http.*
import java.sql.RowId

interface LocationRetrofitinterfaces {

    @GET("/location/default")
    fun getDefault(
        @Query("userId") userId: Int
    ): Call<DefaultResponse>

    @GET("/location/list")
    fun getList(
        @Query("userId") userId: Int
    ): Call<ListResponse>

    @POST("/location/add")
    fun getAddLocation(
        @Body postUserLocationReq : locaAdd,
        @Query("userId") userId : Int
    ): Call<AddResponse>

    @POST("/location/change/default")
    fun getChangeLocation(
        @Body postUserLocationReq : locaAdd,
        @Query ("userId") userId: Int
    ): Call<ChangeLocaResponse>

    @PATCH("/location/delete")
    fun getDeleteLocation(
        @Query("locationId") locationId : Int
    ): Call<DeleteChangeResponse>

}

data class locaAdd(
    val address : String,
    val lat : Double,
    val lng : Double
)