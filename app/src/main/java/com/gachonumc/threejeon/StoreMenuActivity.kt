package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivityStoreMenuBinding
import com.gachonumc.threejeon.store.StoreFragment

class StoreMenuActivity: AppCompatActivity() {

    lateinit var binding: ActivityStoreMenuBinding

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

        supportFragmentManager.beginTransaction().replace(R.id.store_menu_fl, StoreFragment()).commit()

    }

}