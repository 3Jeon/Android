package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStore.setOnClickListener {
            startActivity(Intent(this, StoreMenuActivity::class.java))
        }

        binding.homeMyinformationTv.setOnClickListener {
            startActivity(Intent(this, MyInfoActivity::class.java))
        }

        binding.homeLogoutTv.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}

