package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivityFindpwBinding

class FindPwActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityFindpwBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //로그인하러가기 버튼
        binding.goLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        //뒤로가기 버튼
        binding.findpwBack.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}