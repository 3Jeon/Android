package com.gachonumc.threejeon.Platform.Baemin

import com.google.gson.annotations.SerializedName

data class BaeminStore(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
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
    @SerializedName("expectedDeliveryTimes") val expectedDeliveryTimes: Array<Int>

)

data class BaeminStoreMenu(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: BaeminStoreMenuList
)

data class BaeminStoreMenuList(
    @SerializedName("brestaurantDetail") val brestaurantDetail: BaeminStoreInfo,
    @SerializedName("bmenus") val bmenus: Array<BaeminMenuList>
)

data class BaeminMenuList(
    @SerializedName("description") val description: String,
    @SerializedName("images") val images: Array<String>,
    @SerializedName("menuId") val menuId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: String,
    @SerializedName("soldOut") val soldOut: Boolean
)

data class BaeminStoreInfo(
    @SerializedName("business_Location") val business_Location: String,
    @SerializedName("ct_Cd_Nm") val ct_Cd_Nm: String,
    @SerializedName("ct_Cd_Nm_En") val ct_Cd_Nm_En: String,
    @SerializedName("deliveryInOperation") val deliveryInOperation: Boolean,
    @SerializedName("dlvry_Tm") val dlvry_Tm: String,
    @SerializedName("favorite_Cnt") val favorite_Cnt: Int,
    @SerializedName("images") val images: String,
    @SerializedName("loc_Pnt_Lat") val loc_Pnt_Lat: Double,
    @SerializedName("loc_Pnt_Lng") val loc_Pnt_Lng: Double,
    @SerializedName("min_Ord_Price") val min_Ord_Price: Int,
    @SerializedName("orderCountText") val orderCountText: String,
    @SerializedName("review_Cnt") val review_Cnt: Int,
    @SerializedName("shopStatus") val shopStatus: String,
    @SerializedName("shop_Nm") val shop_Nm: String,
    @SerializedName("shop_No") val shop_No: Int,
    @SerializedName("star_Pnt_Avg") val star_Pnt_Avg: Int,
    @SerializedName("takeoutDiscountPrice") val takeoutDiscountPrice: Int,
    @SerializedName("takeoutDiscountRate") val takeoutDiscountRate: Int,
    @SerializedName("useDelivery") val useDelivery: Boolean,
    @SerializedName("useTakeout") val useTakeout: Boolean,
    @SerializedName("vel_No") val vel_No: String
)

data class BaeminSearch(
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: BaeminSearchStoreList
)

data class BaeminSearchStoreList(
    @SerializedName("address") val address: String,
    @SerializedName("averageStarScore") val averageStarScore: Double,
    @SerializedName("closeDayText") val closeDayText: String,
    @SerializedName("deliveryTip") val deliveryTip: Array<Int>,
    @SerializedName("inOperation") val inOperation: Boolean,
    @SerializedName("logoUrl") val logoUrl: String,
    @SerializedName("minimumOrderPrice") val minimumOrderPrice: Int,
    @SerializedName("shopName") val shopName: String,
    @SerializedName("shopNumber") val shopNumber: Int,
    @SerializedName("telNumber") val telNumber: String,
    @SerializedName("virtualTelNumber") val virtualTelNumber: String,
)