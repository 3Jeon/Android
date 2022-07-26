package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivityMakeaccountBinding

class MakeaccountActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMakeaccountBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.successAccount.setOnClickListener {
            val mIntent = Intent(this, SuccessAccountActivity::class.java)
            startActivity(mIntent)
        }
    }
}

