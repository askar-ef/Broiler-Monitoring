package com.example.broilermonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.LoginPage.Companion.EXTRA_NAME
import com.example.broilermonitoring.LoginPage.Companion.EXTRA_PASS
import com.example.broilermonitoring.databinding.ActivityLoginSuccessBinding

class LoginSuccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(EXTRA_NAME)
        val passwordlog = intent.getStringExtra(EXTRA_PASS)

        with(binding){
            lanjutButton.setOnClickListener {
                val intentLoginSuksesBinding =
                    intent.setClass(this@LoginSuccessActivity, Home::class.java)
                intentLoginSuksesBinding.putExtra(EXTRA_NAME, name)
                intentLoginSuksesBinding.putExtra(EXTRA_PASS, passwordlog)
                startActivity(intentLoginSuksesBinding)
            }
        }
    }
}