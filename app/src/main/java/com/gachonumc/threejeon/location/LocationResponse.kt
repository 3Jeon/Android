package com.gachonumc.threejeon.location

data class DefaultResponse(
    val code : Int,
    val isSuccess : Boolean,
    val message : String,
    val result : DefaultInfo
)

data class DefaultInfo(
    val address : String,
    val createdAt : String,
    val defulatAddress : Boolean,
    val id : Int,
    val lat : Double,
    val lng : Double,
    val updatedAt : String,
    val userId : Int
)

data class ListResponse(
    val code : Int,
    val isSuccess : Boolean,
    val message : String,
    val result : ListInfo
)

data class ListInfo(
    val address : String,
    val createdAt : String,
    val defulatAddress : Boolean,
    val id : Int,
    val lat : Double,
    val lng : Double,
    val status : Boolean,
    val updatedAt : String,
    val userId : Int
)

data class AddResponse(
    val code : Int,
    val isSuccess : Boolean,
    val message : String,
    val result : String
)

data class ChangeLocaResponse(
    val code : Int,
    val isSuccess : Boolean,
    val message : String,
    val result : LocaChangeInfo
)

data class LocaChangeInfo(
    val address: String,
    val createdAt: String,
    val defaultAddress :Boolean,
    val id: Int,
    val lat : Double,
    val lng : Double,
    val status: Boolean,
    val updatedAt: String,
    val userId: Int
)

data class DeleteChangeResponse(
    val code : Int,
    val isSuccess : Boolean,
    val message : String,
    val result : String
)