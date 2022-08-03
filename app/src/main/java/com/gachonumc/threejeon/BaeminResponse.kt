package com.gachonumc.threejeon

import com.google.gson.annotations.SerializedName

data class BaeminStore(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Array<BaeminStoreList>
)

data class BaeminStoreList(
    @SerializedName("shopNumber") val shopNumber: Int,
    @SerializedName("shopName") val shopName: String,
    @SerializedName("thumbnails") val thumbnails: String,
    @SerializedName("inOperation") val inOperation: Boolean,
    @SerializedName("averageStarScore") val averageStarScore: Double,
    @SerializedName("deliveryTips") val deliveryTips: Array<Int>,
    @SerializedName("expectedDeliveryTimes") val expectedDeliveryTimes: Array<Int>,

)