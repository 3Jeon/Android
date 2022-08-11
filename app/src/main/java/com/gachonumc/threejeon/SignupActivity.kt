package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.databinding.ActivitySignupBinding


class SignupActivity : AppCompatActivity() {

    private val enter_location: EditText? = null

    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enterLocation

        if (enter_location != null) {
            enter_location.setOnClickListener {
                fun onClickListener(v: View?) {
                    val i = Intent(this@SignupActivity, WebviewActivity::class.java)
                }
            }
        }

        binding.successAccount.setOnClickListener {
            startActivity(Intent(this, SuccessAccountActivity::class.java))
        }
    }
}