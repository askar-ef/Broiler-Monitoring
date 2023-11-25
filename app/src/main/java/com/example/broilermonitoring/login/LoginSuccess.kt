package com.example.broilermonitoring.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.Pemilik.MainPemilik
import com.example.broilermonitoring.Peternak.MainPeternak
import com.example.broilermonitoring.databinding.ActivityLoginSuccessBinding
import com.example.broilermonitoring.model.Helper

class LoginSuccess : AppCompatActivity() {
    private lateinit var binding: ActivityLoginSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            loginButton.setOnClickListener {
                val status=Helper(this@LoginSuccess).getStatus().toString()
                if (status=="owner"){
                    val intent=Intent(this@LoginSuccess, MainPemilik::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    val intent=Intent(this@LoginSuccess, MainPeternak::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}