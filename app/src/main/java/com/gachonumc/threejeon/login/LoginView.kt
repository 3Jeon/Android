package com.gachonumc.threejeon.login

interface LoginView {
    fun loginInformationSuccess(result : LoginInfo)
    fun loginInformationFailure(code : Int, message : String)
}