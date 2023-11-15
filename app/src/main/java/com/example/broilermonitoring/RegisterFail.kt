package com.example.broilermonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.ActicityRegisterFailBinding

class RegisterFail : AppCompatActivity() {
    private lateinit var binding: ActicityRegisterFailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActicityRegisterFailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            lanjutButton.setOnClickListener {
                val intentRegisterGagalBinding =
                    intent.setClass(this@RegisterFail, RegisterPage::class.java)
                startActivity(intentRegisterGagalBinding)
            }
        }
    }
}