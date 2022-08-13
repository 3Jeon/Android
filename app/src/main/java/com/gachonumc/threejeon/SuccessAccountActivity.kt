package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivitySuccessaccountBinding

class SuccessAccountActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySuccessaccountBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnConfirm.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}