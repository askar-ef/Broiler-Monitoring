package com.example.broilermonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.RegisterGagalBinding

class RegisterGagalActivity : AppCompatActivity() {
    private lateinit var binding: RegisterGagalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterGagalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            lanjutButton.setOnClickListener {
                val intentRegisterGagalBinding =
                    intent.setClass(this@RegisterGagalActivity, RegisterPageActivity::class.java)
                startActivity(intentRegisterGagalBinding)
            }
        }
    }
}