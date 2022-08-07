package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Kakao 로그인
        binding.kakaoLoginBtn.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        //Apple 로그인
        binding.appleLoginBtn.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        //Google 로그인
        binding.googleLoginBtn.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }



    }
}
