package com.gachonumc.threejeon.store

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatViewInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gachonumc.threejeon.Platform.Baemin.BaeminService
import com.gachonumc.threejeon.Platform.Baemin.BaeminStoreList
import com.gachonumc.threejeon.Platform.Baemin.BaeminStoreListView
import com.gachonumc.threejeon.*
import com.gachonumc.threejeon.databinding.FragmentStoreBinding


/*
class StoreActivity: AppCompatActivity(), BaeminStoreListView {

    private var baeminStoreArray = ArrayList<BaeminStoreList>()
    private lateinit var storeAdapter: StoreAdapter

    private val binding by lazy {
        FragmentNavigatorExtras().inflate(layoutInflater)
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

    override fun onResume() {
        super.onResume()
        //baeminInformation(category, lat, lng, sort) //
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

    private fun baeminInformation(category: String, lat: Double, lng: Double, sort : String){
        val baeminStoreService = BaeminService()
        baeminStoreService.setBaeminStoreService(this)
        baeminStoreService.getBaeminStoreService(category, lat, lng, sort)
    }
}

 */

class StoreFragment : Fragment(), BaeminStoreListView{

    private lateinit var binding : FragmentStoreBinding
    private lateinit var storeAdapter: StoreAdapter
    private var baeminStoreArray = ArrayList<BaeminStoreList>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoreBinding.inflate(inflater, container, false)

        val divider = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        binding.storeRv.addItemDecoration(divider)

        //recyclerview 에 adapter 설정
        binding.storeRv.adapter = StoreAdapter(baeminStoreArray)

        //recyclerview 에 layoutManager 설정
        binding.storeRv.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }



    override fun onResume() {
        super.onResume()
        var category : String = "치킨"
        var lat : Double = 37.61254138380022
        var lng : Double = 127.01613952491023
        var sort : String = "rank"
        baeminInformation(category, lat, lng, sort) //
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

    private fun baeminInformation(category : String, lat : Double, lng : Double, sort : String){
        val baeminStoreListView = BaeminService()
        baeminStoreListView.setBaeminStoreService(this)
        baeminStoreListView.getBaeminStoreService(category, lat, lng, sort)
    }

}