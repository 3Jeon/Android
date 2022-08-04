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

        //ID 찾기 버튼
        binding.findId.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        //뒤로가기 버튼
        binding.findidBack.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        //로그인화면으로 가기 버튼
        binding.gotoLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}