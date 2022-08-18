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

    @PATCH("/location/add")
    fun getAddLocation(
        @Body postUserLocationReq : locaAdd,
        @Query("userId") userId : Int
    ): Call<AddResponse>


}

data class locaAdd(
    val address : String,
    val lat : Double,
    val lng : Double
)