package com.gachonumc.threejeon.map

interface MapView {
    fun mapInfoSuccess(result : MapInfo)
    fun mapInfoFailure(code : Int, message : String)
}