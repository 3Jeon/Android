package com.gachonumc.threejeon.login

data class LoginResponse (
    val code : Int,
    val isSuccess : Boolean,
    val message : String,
    val result : LoginInfo
)

data class LoginInfo(
    val jwt : String,
    val userId : Int
)