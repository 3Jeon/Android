package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.Platform.Baemin.*
import com.gachonumc.threejeon.Platform.Coupang.CoupangSearch
import com.gachonumc.threejeon.Platform.Coupang.CoupangSearchList
import com.gachonumc.threejeon.Platform.Coupang.CoupangSearchListView
import com.gachonumc.threejeon.Platform.Yogiyo.YogiyoSearch
import com.gachonumc.threejeon.Platform.Yogiyo.YogiyoSearchListView
import com.gachonumc.threejeon.Platform.Yogiyo.YogiyoSearchStoreList
import com.gachonumc.threejeon.databinding.ActivitySearchBinding
import com.gachonumc.threejeon.store.StoreActivity

//intent로 어떤걸 검색하는지 주고, if로 나누면 될듯
class SearchActivity : AppCompatActivity(), BaeminSearchView, YogiyoSearchListView, CoupangSearchListView, BaeminStoreMenuView {
    lateinit var binding : ActivitySearchBinding

    private var baeminStoreArray = ArrayList<BaeminSearchStoreList>()
    private var yogiyoStoreArray = ArrayList<YogiyoSearchStoreList>()
    private var coupangStoreArray = ArrayList<CoupangSearchList>()
    private var baeminStoreMenuArray = ArrayList<BaeminMenuList>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchBack.setOnClickListener {
            startActivity(Intent(this, StoreActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        //각 search 결과들 보여주면 될듯.
    }

    override fun baeminSearchSuccess(result: Array<BaeminSearchStoreList>) {
        val resultSize = result.size

        for(i in 0 until resultSize){
            var address = result.get(i).address
            var averageStarScore = result.get(i).averageStarScore
            var closeDayText = result.get(i).address
            var deliveryTip = result.get(i).deliveryTip
            var inOperation = result.get(i).inOperation
            var logoUrl = result.get(i).logoUrl
            var minimumOrderPrice = result.get(i).minimumOrderPrice
            var shopName = result.get(i).shopName
            var shopNumber = result.get(i).shopNumber
            var telNumber = result.get(i).telNumber
            var virtualTelNumber = result.get(i).virtualTelNumber

            baeminStoreArray.add(
                BaeminSearchStoreList(address, averageStarScore, closeDayText, deliveryTip,inOperation,
                    logoUrl, minimumOrderPrice, shopName, shopNumber, telNumber, virtualTelNumber)
            )

        }
    }


    override fun baeminSearchFailure(code: Int, message: String) {
        TODO("Not yet implemented")
    }

    override fun yogiyoStoreListSuccess(result: Array<YogiyoSearchStoreList>) {
        val resultSize = result.size

        for(i in 0 until resultSize){
            var _available_delivery = result.get(i)._available_delivery
            var _available_pickup = result.get(i)._available_pickup
            var additional_discount = result.get(i).additional_discount
            var address = result.get(i).address
            var adjusted_delivery_fee = result.get(i).adjusted_delivery_fee
            var category = result.get(i).category
            var distance = result.get(i).distance
            var estimated_delivery_time = result.get(i).estimated_delivery_time
            var free_delivery_threshold = result.get(i).free_delivery_threshold
            var has_shop_coupons = result.get(i).has_shop_coupons
            var id = result.get(i).id
            var lat = result.get(i).lat
            var lng = result.get(i).lng
            var logo_url = result.get(i).logo_url
            var min_order_amount = result.get(i).min_order_amount
            var minimum_pickup_minutes = result.get(i).minimum_pickup_minutes
            var name = result.get(i).name
            var open = result.get(i).open
            var phone = result.get(i).phone
            var review_avg = result.get(i).review_avg
            var review_count = result.get(i).review_count


            yogiyoStoreArray.add(YogiyoSearchStoreList(
                _available_delivery, _available_pickup, additional_discount, address, adjusted_delivery_fee,
                category, distance, estimated_delivery_time, free_delivery_threshold, has_shop_coupons,
                id, lat, lng, logo_url, min_order_amount, minimum_pickup_minutes, name, open, phone, review_avg, review_count
            )
            )
        }
    }

    override fun yogiyoStroeListFailure(code: Int, message: String) {
        TODO("Not yet implemented")
    }

    override fun coupangSearchListSuccess(result: Array<CoupangSearchList>) {
        val resultSize = result.size

        for(i in 0 until resultSize){
            var address = result.get(i).address
            var description = result.get(i).description
            var estimatedDeliveryTime = result.get(i).estimatedDeliveryTime
            var id = result.get(i).id
            var images = result.get(i).images
            var latitude = result.get(i).latitude
            var longitude = result.get(i).longitude
            var minimumOrderPriceForDelivery = result.get(i).minimumOrderPriceForDelivery
            var name = result.get(i).name
            var openStatus = result.get(i).openStatus
            var pickupAvailable = result.get(i).pickupAvailable
            var pickupEstimationFoodTimeText = result.get(i).pickupEstimationFoodTimeText
            var reviewCount = result.get(i).reviewCount
            var reviewRating = result.get(i).reviewRating
            var supportedPickup = result.get(i).supportedPickup
            var telNo = result.get(i).telNo

            coupangStoreArray.add(
                CoupangSearchList(address, description, estimatedDeliveryTime, id, images, latitude, longitude,
                    minimumOrderPriceForDelivery, name, openStatus, pickupAvailable, pickupEstimationFoodTimeText,
                    reviewCount, reviewRating, supportedPickup, telNo)
            )

        }
    }

    override fun coupangSearchListFailure(code: Int, message: String) {
        TODO("Not yet implemented")
    }

    override fun baeminStoreMenuSuccess(result: BaeminStoreMenuList) {

        val menuResult = result.bmenus.size

        for(i in 0 until menuResult){
            var description = result.bmenus.get(i).description
            var images = result.bmenus.get(i).images
            var menuId = result.bmenus.get(i).menuId
            var name = result.bmenus.get(i).name
            var price = result.bmenus.get(i).price
            var soldOut = result.bmenus.get(i).soldOut

            baeminStoreMenuArray.add(
                BaeminMenuList(description, images, menuId, name, price, soldOut)
            )
        }
    }

    override fun baeminStoreMenuFailure(code: Int, message: String) {
        TODO("Not yet implemented")
    }

    private fun baeminStoreMenuIn(restaurant_id : Int){
        val baeminStoreMenuService = BaeminService()
        baeminStoreMenuService.setBaeminStoreMenuService(this)
        baeminStoreMenuService.getBaeminStoreMenuService(restaurant_id)
    }

}