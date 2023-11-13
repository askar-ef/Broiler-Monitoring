package com.example.broilermonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.LoginPage.Companion.EXTRA_NAME
import com.example.broilermonitoring.LoginPage.Companion.EXTRA_PASS
import com.example.broilermonitoring.databinding.LoginSuksesBinding

class LoginSuksesActivity : AppCompatActivity() {
    private lateinit var binding: LoginSuksesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginSuksesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(EXTRA_NAME)
        val passwordlog = intent.getStringExtra(EXTRA_PASS)

        with(binding){
            lanjutButton.setOnClickListener {
                val intentLoginSuksesBinding =
                    intent.setClass(this@LoginSuksesActivity, HomePageActivity::class.java)
                intentLoginSuksesBinding.putExtra(EXTRA_NAME, name)
                intentLoginSuksesBinding.putExtra(EXTRA_PASS, passwordlog)
                startActivity(intentLoginSuksesBinding)
            }
        }
    }
}