package com.gachonumc.threejeon.mymenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gachonumc.threejeon.databinding.ActivityMymenuBinding
import com.gachonumc.threejeon.databinding.ActivityStoreBinding

class MyMenuActivity: AppCompatActivity() {

    private val binding by lazy {
        ActivityMymenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //RecyclerView 에 구분선 넣기
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.mymenuRv.addItemDecoration(divider)

        //recyclerview 에 adapter 설정
        binding.mymenuRv.adapter = MyMenuAdapter()

        //recyclerview 에 layoutManager 설정
        binding.mymenuRv.layoutManager = LinearLayoutManager(this)
    }
}