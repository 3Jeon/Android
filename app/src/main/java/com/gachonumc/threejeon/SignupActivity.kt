package com.gachonumc.threejeon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gachonumc.threejeon.NetworkStatus.getConnectivityStatus
import com.gachonumc.threejeon.databinding.ActivitySignupBinding


class SignupActivity : AppCompatActivity() {
    lateinit var binding : ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enterLocation.setOnClickListener{

            Log.i("주소설정페이지", "주소입력창 클릭")
            val status = getConnectivityStatus(applicationContext)
            if (status == NetworkStatus.TYPE_MOBILE || status == NetworkStatus.TYPE_WIFI) {

                Log.i("주소설정페이지", "주소입력창 클릭")
                Intent i = new Intent(getApplicationContext(), AddressActivity.class)
                        overridePendingTransition(0, 0)
                startActivity(i, AddressActivity)

            } else {
                Toast.makeText(applicationContext, "인터넷 연결을 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.successAccount.setOnClickListener {
            startActivity(Intent(this, SuccessAccountActivity::class.java))
        }
    }
}