package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivityMyinfoBinding

class MyInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityMyinfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myinfoBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}