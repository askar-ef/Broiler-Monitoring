package com.example.broilermonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.PasswordBinding

class PasswordActivity : AppCompatActivity() {
    private lateinit var binding: PasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            button.setOnClickListener {
                val intentPasswordBinding =
                    Intent(this@PasswordActivity, AkunActivity::class.java)
                startActivity(intentPasswordBinding)
                }
        }
    }
}