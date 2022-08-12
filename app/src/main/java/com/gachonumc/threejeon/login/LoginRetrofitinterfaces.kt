package com.gachonumc.threejeon.login

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginRetrofitinterfaces {

    @GET("/auth")
    fun getLoginInformation(
    @Query("id") id : Int,
    @Query("jwt") jwt : String
    ) : Call<LoginResponse>
}