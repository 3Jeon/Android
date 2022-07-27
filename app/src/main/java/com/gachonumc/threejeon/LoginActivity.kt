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

        //회원가입
        binding.makeAccount.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        //id 찾기
        binding.loginSearchId.setOnClickListener {
            startActivity(Intent(this, FindIdActivity::class.java))
        }

        //pw 찾기
        binding.loginSearchPw.setOnClickListener {
            startActivity(Intent(this, FindPwActivity::class.java))
        }

        //로그인 확인
        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }


    }
}
