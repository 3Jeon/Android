package com.gachonumc.threejeon.store

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
<<<<<<< HEAD
import com.gachonumc.threejeon.Baemin.BaeminService
import com.gachonumc.threejeon.Baemin.BaeminStoreList
import com.gachonumc.threejeon.Baemin.BaeminStoreListView
=======
import com.gachonumc.threejeon.*
>>>>>>> 5a85da211c8fd4aad687f49404dbaa08f028575e
import com.gachonumc.threejeon.databinding.ActivityStoreBinding
import com.gachonumc.threejeon.menu.MenuActivity

class StoreActivity: AppCompatActivity(), BaeminStoreListView {

    private var baeminStoreArray = ArrayList<BaeminStoreList>()
    private lateinit var storeAdapter: StoreAdapter

    private val binding by lazy {
        ActivityStoreBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //RecyclerView 에 구분선 넣기
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.storeRv.addItemDecoration(divider)

        //recyclerview 에 adapter 설정
        binding.storeRv.adapter = StoreAdapter(baeminStoreArray)

        //recyclerview 에 layoutManager 설정
        binding.storeRv.layoutManager = LinearLayoutManager(this)

        binding.storeBackIv.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.storeSearchIv.setOnClickListener{
            startActivity(Intent(this, SearchActivity::class.java))
        }

        binding.chooseMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }

    override fun baeminStoreListSuccess(result: Array<BaeminStoreList>) {
        val resultSize = result.size

        for(i in 0 until resultSize){
            var shopNumber = result.get(i).shopNumber
            var shopName = result.get(i).shopName
            var thumbnails = result.get(i).thumbnails
            var inOperation = result.get(i).inOperation
            var averageStarScore = result.get(i).averageStarScore
            var deliveryTips = result.get(i).deliveryTips
            var expectedDeliveryTimes = result.get(i).expectedDeliveryTimes

            baeminStoreArray.add(
                BaeminStoreList(shopNumber, shopName, thumbnails, inOperation, averageStarScore, deliveryTips, expectedDeliveryTimes)
            )
        }


    }

    override fun baeminStoreListFailure(code: Int, message: String) {
        TODO("Not yet implemented")
    }

    private fun baeminInformation(category: String, lat: Double, lng: Double){
        val baeminStoreService = BaeminService()
        baeminStoreService.setBaeminStoreService(this)
        baeminStoreService.getBaeminStoreService(category, lat, lng)
    }
}