package com.example.broilermonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        val loginButton: Button = findViewById(R.id.button)
        loginButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                Toast.makeText(applicationContext, "Login Berhasil", Toast.LENGTH_SHORT).show()
            }
        })
    }
}