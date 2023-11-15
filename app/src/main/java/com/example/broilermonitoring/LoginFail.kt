package com.example.broilermonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.ActivityLoginFailBinding

class LoginFail : AppCompatActivity() {
    private lateinit var binding: ActivityLoginFailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginFailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            lanjutButton.setOnClickListener {
                val intentLoginGagalBinding =
                    intent.setClass(this@LoginFail, LoginPage::class.java)
                startActivity(intentLoginGagalBinding)
            }
        }
    }
}