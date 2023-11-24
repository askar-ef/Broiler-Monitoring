package com.example.broilermonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.ActivityRegisterSuccessBinding

class RegisterSuccess : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            nextButton.setOnClickListener {
                val intent= Intent(this@RegisterSuccess,LoginPage::class.java)
                startActivity(intent)
            }
        }
    }
}