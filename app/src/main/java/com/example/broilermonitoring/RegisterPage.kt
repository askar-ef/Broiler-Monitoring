package com.example.broilermonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.ActivityRegisterPageBinding
import com.google.android.material.textfield.TextInputEditText

class RegisterPage : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterPageBinding
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_PASS1 = "extra_pass"
        const val EXTRA_PHONE = "extra_phone"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val namaLengkapInput = findViewById<TextInputEditText>(R.id.nama_lengkap_input)
        val usernameInput = findViewById<TextInputEditText>(R.id.username_input)
        val passwordInput = findViewById<TextInputEditText>(R.id.password_input)
        val emailInput = findViewById<TextInputEditText>(R.id.email_input)
        val handphoneInput = findViewById<TextInputEditText>(R.id.handphone_input)

        with(binding){
            button.setOnClickListener {
                val intentTologinPageActivity =
                    Intent(this@RegisterPage, RegisterSuccess::class.java)
                intentTologinPageActivity.putExtra(EXTRA_NAME, namaLengkapInput.text.toString())
                intentTologinPageActivity.putExtra(EXTRA_USERNAME, usernameInput.text.toString())
                intentTologinPageActivity.putExtra(EXTRA_PASS1, passwordInput.text.toString())
                intentTologinPageActivity.putExtra(EXTRA_EMAIL, emailInput.text.toString())
                intentTologinPageActivity.putExtra(EXTRA_PHONE, handphoneInput.text.toString())
                startActivity(intentTologinPageActivity)
            }
        }
    }
}