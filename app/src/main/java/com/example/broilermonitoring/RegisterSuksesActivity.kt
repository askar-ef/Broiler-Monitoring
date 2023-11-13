package com.example.broilermonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.RegisterPageActivity.Companion.EXTRA_EMAIL
import com.example.broilermonitoring.RegisterPageActivity.Companion.EXTRA_PASS1
import com.example.broilermonitoring.RegisterPageActivity.Companion.EXTRA_PHONE
import com.example.broilermonitoring.RegisterPageActivity.Companion.EXTRA_USERNAME
import com.example.broilermonitoring.databinding.RegisterSuksesBinding

class RegisterSuksesActivity : AppCompatActivity() {
    private lateinit var binding: RegisterSuksesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterSuksesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = intent.getStringExtra(EXTRA_USERNAME)
        val password = intent.getStringExtra(EXTRA_PASS1)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val handphone = intent.getStringExtra(EXTRA_PHONE)

        with(binding){
            lanjutButton.setOnClickListener {
                val intentRegisterSuksesBinding =
                    intent.setClass(this@RegisterSuksesActivity, HomePageActivity::class.java)
                intentRegisterSuksesBinding.putExtra(EXTRA_USERNAME, username)
                intentRegisterSuksesBinding.putExtra(EXTRA_PASS1, password)
                intentRegisterSuksesBinding.putExtra(EXTRA_EMAIL, email)
                intentRegisterSuksesBinding.putExtra(EXTRA_PHONE, handphone)
                startActivity(intentRegisterSuksesBinding)
            }
        }
    }
}