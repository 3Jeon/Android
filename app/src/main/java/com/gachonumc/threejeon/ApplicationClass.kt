
/*
package com.gachonumc.threejeon


import android.app.Application
import android.content.SharedPreferences
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationClass: Application() {
    companion object {
        const val BASE_URL = "https://duckbilllvrzeno.shop" //도메인 주소 넣기

        lateinit var retrofit: Retrofit
        lateinit var mSharedPreferences: SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()

        //레트로핏
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
        /*.client(client)*/
        .addConverterFactory(GsonConverterFactory.create())
            .build()

        //SharedPreference
        /*
        mSharedPreferences = applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE)
        if(getUuid()==null){ //uuid가 존재하지 않으면,
            val uuid = UUID.randomUUID().toString() //uuid 생성
            saveUuid(uuid) // sharedpref에 저장
        }

         */
    }
}


 */