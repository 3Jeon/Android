package com.gachonumc.threejeon.Platform.Yogiyo

import com.gachonumc.threejeon.Platform.Baemin.BaeminStoreList
import com.google.gson.annotations.SerializedName

data class YogiyoSearch (
        @SerializedName("code") val code: Int,
        @SerializedName("isSuccess") val isSuccess: Boolean,
        @SerializedName("message") val message: String,
        @SerializedName("result") val result: Array<YogiyoSearchStoreList>
        )

data class YogiyoSearchStoreList(
        @SerializedName("_available_delivery") val _available_delivery: Boolean,
        @SerializedName("_available_pickup") val _available_pickup: Boolean,
        @SerializedName("additional_discount") val additional_discount: Int,
        @SerializedName("address") val address: String,
        @SerializedName("adjusted_delivery_fee") val adjusted_delivery_fee: Int,
        @SerializedName("category") val category: Array<String>,
        @SerializedName("distance") val distance: Int,
        @SerializedName("estimated_delivery_time") val estimated_delivery_time: String,
        @SerializedName("free_delivery_threshold") val free_delivery_threshold: Int,
        @SerializedName("has_shop_coupons") val has_shop_coupons: Boolean,
        @SerializedName("id") val id: Int,
        @SerializedName("lat") val lat: Double,
        @SerializedName("lng") val lng: Double,
        @SerializedName("logo_url") val logo_url: String,
        @SerializedName("min_order_amount") val min_order_amount: Int,
        @SerializedName("minimum_pickup_minutes") val minimum_pickup_minutes: Int,
        @SerializedName("name") val name: String,
        @SerializedName("open") val open: Boolean,
        @SerializedName("phone") val phone: String,
        @SerializedName("review_avg") val review_avg: Int,
        @SerializedName("review_count") val review_count: Int


)