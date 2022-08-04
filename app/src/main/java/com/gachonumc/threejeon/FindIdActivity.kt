package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivityFindidBinding

class FindIdActivity: AppCompatActivity() {
    lateinit var binding : ActivityFindidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //회원가입
        binding.gotoLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}