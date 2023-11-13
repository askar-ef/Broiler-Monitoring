package com.example.broilermonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.LoginGagalBinding

class LoginGagalActivity : AppCompatActivity() {
    private lateinit var binding: LoginGagalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginGagalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            lanjutButton.setOnClickListener {
                val intentLoginGagalBinding =
                    intent.setClass(this@LoginGagalActivity, LoginPage::class.java)
                startActivity(intentLoginGagalBinding)
            }
        }
    }
}