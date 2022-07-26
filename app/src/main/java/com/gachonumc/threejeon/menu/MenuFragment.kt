package com.gachonumc.threejeon.menu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gachonumc.threejeon.Platform.Baemin.*
import com.gachonumc.threejeon.SearchActivity
import com.gachonumc.threejeon.databinding.FragmentMenuBinding
import com.gachonumc.threejeon.databinding.FragmentStoreBinding
import com.gachonumc.threejeon.mymenu.MyMenuActivity
import com.gachonumc.threejeon.store.StoreAdapter

/*
class MenuActivity: AppCompatActivity(), BaeminStoreMenuView {

    private var baeminStoreMenuArray = ArrayList<BaeminMenuList>()

    private val binding by lazy {
        ActivityMenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //RecyclerView 에 구분선 넣기
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.menuRv.addItemDecoration(divider)

        //recyclerview 에 adapter 설정
        binding.menuRv.adapter = MenuAdapter()

        //recyclerview 에 layoutManager 설정
        binding.menuRv.layoutManager = LinearLayoutManager(this)

        binding.menuBackIv.setOnClickListener {
            startActivity(Intent(this, StoreActivity::class.java))
        }

        binding.goMyMenu.setOnClickListener {
            startActivity(Intent(this, MyMenuActivity::class.java))
        }

        binding.menuSearchIv.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
            //intent로 메뉴검색이라는 필터링 하나 넣어줘야할듯
        }
    }

    override fun onResume() {
        super.onResume()
        //baeminStoreMenuIn(category, lat, lng, sort) //
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

 */

class MenuFragment : Fragment(), BaeminStoreMenuView {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var menuAdapter: StoreAdapter
    private var baeminStoreMenuArray = ArrayList<BaeminMenuList>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        val divider = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        binding.menuRv.addItemDecoration(divider)

        //recyclerview 에 adapter 설정
        binding.menuRv.adapter = MenuAdapter()

        //recyclerview 에 layoutManager 설정
        binding.menuRv.layoutManager = LinearLayoutManager(activity)


        return binding.root

    }


    override fun onResume() {
        super.onResume()
        var restaurant_id : Int = 123124 // 이 값에 가게정보를 넣으면 됨
        baeminStoreMenuIn(restaurant_id) //
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