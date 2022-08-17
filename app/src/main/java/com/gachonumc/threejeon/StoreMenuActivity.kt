package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gachonumc.threejeon.Platform.Baemin.BaeminStoreList
import com.gachonumc.threejeon.databinding.ActivityStoreMenuBinding
import com.gachonumc.threejeon.databinding.FragmentStoreBinding
import com.gachonumc.threejeon.store.StoreAdapter
import com.gachonumc.threejeon.store.StoreFragment

class StoreMenuActivity: AppCompatActivity() {

    lateinit var binding: ActivityStoreMenuBinding

    private var baeminStoreArray = ArrayList<BaeminStoreList>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoreMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.menuCartIv.setOnClickListener {
            startActivity(Intent(this, MyMenuActivity::class.java))
        }

        binding.menuBackIv.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.storeMenuRv.adapter = StoreAdapter(baeminStoreArray)

        //recyclerview 에 layoutManager 설정
        binding.storeMenuRv.layoutManager = LinearLayoutManager(this)

        //supportFragmentManager.beginTransaction().replace(androidx.fragment.R.id.fragment_container_view_tag, StoreFragment()).commit()
    }

}