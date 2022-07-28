package com.gachonumc.threejeon.mymenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gachonumc.threejeon.databinding.ActivityStoreBinding

class MyMenuActivity: AppCompatActivity() {

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
        binding.storeRv.adapter = MyMenuAdapter()

        //recyclerview 에 layoutManager 설정
        binding.storeRv.layoutManager = LinearLayoutManager(this)
    }
}