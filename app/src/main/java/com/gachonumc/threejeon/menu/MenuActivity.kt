package com.gachonumc.threejeon.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gachonumc.threejeon.Baemin.*
import com.gachonumc.threejeon.databinding.ActivityStoreBinding

class MenuActivity: AppCompatActivity(), BaeminStoreMenuView {

    private var baeminStoreMenuArray = ArrayList<BaeminMenuList>()

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
        binding.storeRv.adapter = MenuAdapter()

        //recyclerview 에 layoutManager 설정
        binding.storeRv.layoutManager = LinearLayoutManager(this)
    }

    override fun baeminStoreMenuSuccess(result : BaeminStoreMenuList) {
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