package com.gachonumc.threejeon.menu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gachonumc.threejeon.SearchActivity
import com.gachonumc.threejeon.databinding.ActivityMenuBinding
import com.gachonumc.threejeon.mymenu.MyMenuActivity
import com.gachonumc.threejeon.store.StoreActivity

class MenuActivity: AppCompatActivity() {

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
        }
    }
}