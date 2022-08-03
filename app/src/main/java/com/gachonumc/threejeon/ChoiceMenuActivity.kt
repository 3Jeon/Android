package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivityChoicemenuBinding

class ChoiceMenuActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityChoicemenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.goMyMenu.setOnClickListener {
            val mIntent = Intent(this, MyMenuActivity::class.java)
            startActivity(mIntent)
        }
    }
}