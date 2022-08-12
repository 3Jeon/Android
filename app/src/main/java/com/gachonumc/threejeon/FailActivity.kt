package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivityFailBinding
import com.gachonumc.threejeon.menu.MenuFragment

class FailActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityFailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.returnMenu.setOnClickListener {
            val mIntent = Intent(this, MenuFragment::class.java)
            startActivity(mIntent)
        }
    }


}