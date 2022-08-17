package com.gachonumc.threejeon.map

interface MapView {
    fun mapInfoSuccess(result : MapInfo)
    fun mapInfoFailure(code : Int, message : String)
}
interface GeoView{
    fun geoInfoSuccess(result: GeoInfo)
    fun geoInfoFailure(code: Int, message: String)
}