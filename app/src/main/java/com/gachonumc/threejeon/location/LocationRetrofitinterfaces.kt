package com.gachonumc.threejeon.location

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
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
}