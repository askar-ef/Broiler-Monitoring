package com.example.broilermonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.RegisterPage.Companion.EXTRA_EMAIL
import com.example.broilermonitoring.RegisterPage.Companion.EXTRA_PASS1
import com.example.broilermonitoring.RegisterPage.Companion.EXTRA_PHONE
import com.example.broilermonitoring.RegisterPage.Companion.EXTRA_USERNAME
import com.example.broilermonitoring.databinding.ActivityRegisterSuccessBinding

class RegisterSuccess : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = intent.getStringExtra(EXTRA_USERNAME)
        val password = intent.getStringExtra(EXTRA_PASS1)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val handphone = intent.getStringExtra(EXTRA_PHONE)

        with(binding){
            lanjutButton.setOnClickListener {
                val intentRegisterSuksesBinding =
                    intent.setClass(this@RegisterSuccess, Home::class.java)
                intentRegisterSuksesBinding.putExtra(EXTRA_USERNAME, username)
                intentRegisterSuksesBinding.putExtra(EXTRA_PASS1, password)
                intentRegisterSuksesBinding.putExtra(EXTRA_EMAIL, email)
                intentRegisterSuksesBinding.putExtra(EXTRA_PHONE, handphone)
                startActivity(intentRegisterSuksesBinding)
            }
        }
    }
}