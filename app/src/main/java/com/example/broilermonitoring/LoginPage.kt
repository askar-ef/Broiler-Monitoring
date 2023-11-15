package com.example.broilermonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.ActivityLoginPageBinding
import com.google.android.material.textfield.TextInputEditText

class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PASS = "extra_pass"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val usernameInput = findViewById<TextInputEditText>(R.id.username_input)
        val passwordInput = findViewById<TextInputEditText>(R.id.password_input)
//        val user = arrayOf()
//        val pass = mapOf(
//            "admin" to "admin",
//            "user" to "user")
//        fun isLoginValid(username: String, password: String): Boolean {
//            val storedPassword = pass[username]
//            return storedPassword != null && storedPassword == password
//        }

        with(binding){
            loginButton.setOnClickListener{
                val intentActivityLoginPageBinding =
                    Intent(this@LoginPage, LoginSuccessActivity::class.java)
                intentActivityLoginPageBinding.putExtra(EXTRA_NAME, usernameInput.text.toString())
                intentActivityLoginPageBinding.putExtra(EXTRA_PASS, passwordInput.text.toString())
                startActivity(intentActivityLoginPageBinding)
            }
            forgot.setOnClickListener {
                val intentActivityLoginPageBinding =
                    Intent(this@LoginPage, Password::class.java)
                startActivity(intentActivityLoginPageBinding)
            }
            signIn.setOnClickListener{
                val intentActivityLoginPageBinding =
                    Intent(this@LoginPage, RegisterPage::class.java)
                startActivity(intentActivityLoginPageBinding)
            }
        }
    }
}