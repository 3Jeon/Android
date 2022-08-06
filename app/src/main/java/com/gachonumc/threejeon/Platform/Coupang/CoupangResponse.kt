package com.gachonumc.threejeon.Platform.Coupang

import com.google.gson.annotations.SerializedName

data class CoupangSearch(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Array<CoupangSearchList>
)

data class CoupangSearchList(
    @SerializedName("address") val address: String,
    @SerializedName("description") val description: String,
    @SerializedName("estimatedDeliveryTime") val estimatedDeliveryTime: String,
    @SerializedName("id") val id: Int,
    @SerializedName("images") val images: Array<String>,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("minimumOrderPriceForDelivery") val minimumOrderPriceForDelivery: Int,
    @SerializedName("_available_delivery") val name: String,
    @SerializedName("openStatus") val openStatus: String,
    @SerializedName("pickupAvailable") val pickupAvailable: Boolean,
    @SerializedName("pickupEstimationFoodTimeText") val pickupEstimationFoodTimeText: String,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("reviewRating") val reviewRating: Double,
    @SerializedName("supportedPickup") val supportedPickup: Boolean,
    @SerializedName("telNo") val telNo: String


)



//data class CoupangStoreMenu (
//    @SerializedName("code") val code: Int,
//    @SerializedName("isSuccess") val isSuccess: Boolean,
//    @SerializedName("message") val message: String,
//    @SerializedName("result") val result: Array<CoupangStoreMenuList>
//)
//
//data class CoupangStoreMenuList(
//    @SerializedName("description") val description: String,
//    @SerializedName("estimatedDeliveryTime") val estimatedDeliveryTime: String,
//    @SerializedName("estimatedPickupTime") val estimatedPickupTime: String,
//    @SerializedName("id") val id: Int,
//    @SerializedName("images") val images: Array<String>,
//    @SerializedName("latitude") val latitude: Int,
//    @SerializedName("longitude") val longitude: Int,
//    @SerializedName("minimumOrderPriceForDelivery") val minimumOrderPriceForDelivery: Int,
//    @SerializedName("name") val name: String,
//    @SerializedName("openStatus") val openStatus: String,
//    @SerializedName("pickupAddress") val pickupAddress: String,
//    @SerializedName("pickupAvailable") val pickupAvailable: Boolean,
//    @SerializedName("reviewCount") val reviewCount: Int,
//    @SerializedName("reviewRating") val reviewRating: Int,
//    @SerializedName("supportedPickup") val supportedPickup: Boolean,
//    @SerializedName("telNo") val telNo: String,
//    @SerializedName("cmenus") val cmenus: Array<CoupangMenuList>
//    )
//
//data class CoupangMenuList(
//    @SerializedName("description") val description: String,
//    @SerializedName("displayStatusText") val displayStatusText: String,
//    @SerializedName("id") val id: Int,
//    @SerializedName("images") val images: Array<String>,
//    @SerializedName("name") val name: String,
//    @SerializedName("salePrice") val salePrice: Int,
//    @SerializedName("storeId") val storeId: Int
//)
//
//data class CoupangStore(
//    @SerializedName("code") val code: Int,
//    @SerializedName("isSuccess") val isSuccess: Boolean,
//    @SerializedName("message") val message: String,
//    @SerializedName("result") val result: Array<CoupangStoreList>
//)
//
//data class CoupangStoreList(
//    @SerializedName("address") val address: String,
//    @SerializedName("description") val description: String,
//    @SerializedName("estimatedDeliveryTime") val estimatedDeliveryTime: String,
//    @SerializedName("id") val id: Int,
//    @SerializedName("images") val images: Array<String>,
//    @SerializedName("latitude") val latitude: Int,
//    @SerializedName("longitude") val longitude: Int,
//    @SerializedName("minimumOrderPriceForDelivery") val minimumOrderPriceForDelivery: Double,
//    @SerializedName("name") val name: String,
//    @SerializedName("openStatus") val openStatus: String,
//    @SerializedName("pickupAvailable") val pickupAvailable: Boolean,
//    @SerializedName("pickupEstimationFoodTimeText") val pickupEstimationFoodTimeText: String,
//    @SerializedName("reviewCount") val reviewCount: Int,
//    @SerializedName("reviewRating") val reviewRating: Double,
//    @SerializedName("supportedPickup") val supportedPickup: Boolean,
//    @SerializedName("telNo") val telNo: String,
//
//)