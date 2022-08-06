package com.gachonumc.threejeon.login

import android.util.Log
import com.gachonumc.threejeon.NetworkModule
import com.gachonumc.threejeon.map.MapResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class LoginService {

    private lateinit var loginView : LoginView

    fun setLoginService(loginView: LoginView){
        this.loginView = loginView
    }

    fun getLoginService(id : Int, jwt : String){
        val loginService = NetworkModule.getInstance()?.create(LoginRetrofitinterfaces::class.java)
        loginService?.getLoginInformation(id, jwt)?.enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val loginResponse : LoginResponse = response.body()!!
                when(loginResponse.code){
                    1000 -> loginView.loginInformationSuccess(loginResponse.result)
                    else -> loginView.loginInformationFailure(loginResponse.code, loginResponse.message)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("Server off", "로그인인 서버 꺼져버렸당")
            }

        })
    }
}