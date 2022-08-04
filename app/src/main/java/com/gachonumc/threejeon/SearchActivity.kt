package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivitySearchBinding
import com.gachonumc.threejeon.store.StoreActivity

class SearchActivity : AppCompatActivity() {
    lateinit var binding : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchBack.setOnClickListener {
            startActivity(Intent(this, StoreActivity::class.java))
        }
    }
}