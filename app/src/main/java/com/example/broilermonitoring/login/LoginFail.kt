package com.example.broilermonitoring.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.ActivityLoginFailBinding

class LoginFail : AppCompatActivity() {
    private lateinit var binding: ActivityLoginFailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginFailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            nextButton.setOnClickListener {
                val intent=Intent(this@LoginFail, LoginPage::class.java)
                startActivity(intent)
            }
        }
    }
}