package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.makeAccount.setOnClickListener {
            val mIntent = Intent(this, SuccessAccountActivity::class.java)
            startActivity(mIntent)
        }
    }
}