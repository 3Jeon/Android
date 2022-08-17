package com.gachonumc.threejeon.map

data class MapResponse (
    val code : Int,
    val isSuccess : Boolean,
    val message : String,
    val result : MapInfo
    )

data class MapInfo(
    val currentDateTime : String,
    val departureTime : String,
    val distance : Int,
    val duration : Int,
    val fuelPrice : Int,
    val goal : Array<Double>,
    val start : Array<Double>,
    val taxiFare : Int,
    val tollFare : Int
)

data class GeocodeResponse(
    val code : Int,
    val isSuccess : Boolean,
    val message : String,
    val result : GeoInfo
)

data class GeoInfo(
    val distance: Double,
    val jibunAddress : String,
    val roadAddress : String,
    val x : Double,
    val y : Double
)