package com.example.broilermonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.LaporanBinding

class LaporanActivity : AppCompatActivity() {
    private lateinit var binding: LaporanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LaporanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNav = binding.bottomMenu
        val name = intent.getStringExtra(LoginPage.EXTRA_NAME)
        val passwordlog = intent.getStringExtra(LoginPage.EXTRA_PASS)
        val username = intent.getStringExtra(RegisterPageActivity.EXTRA_USERNAME)
        val password = intent.getStringExtra(RegisterPageActivity.EXTRA_PASS1)
        val email = intent.getStringExtra(RegisterPageActivity.EXTRA_EMAIL)
        val handphone = intent.getStringExtra(RegisterPageActivity.EXTRA_PHONE)
        with(binding){
            bottomNav.onItemSelected = {
                when(it){
                    0 -> {
                        val intentHomePageActivity =
                            Intent(this@LaporanActivity, HomePageActivity::class.java)
                        intentHomePageActivity.putExtra(LoginPage.EXTRA_NAME, name)
                        intentHomePageActivity.putExtra(LoginPage.EXTRA_PASS, passwordlog)
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_USERNAME, username.toString())
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_PASS1, password)
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_EMAIL, email)
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_PHONE, handphone)
                        startActivity(intentHomePageActivity)
                    }
                    1 -> {
                        val intentHomePageActivity =
                            Intent(this@LaporanActivity, DashboardActivity::class.java)
                        intentHomePageActivity.putExtra(LoginPage.EXTRA_NAME, name)
                        intentHomePageActivity.putExtra(LoginPage.EXTRA_PASS, passwordlog)
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_USERNAME, username.toString())
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_PASS1, password)
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_EMAIL, email)
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_PHONE, handphone)
                        startActivity(intentHomePageActivity)
                    }
                    2 -> {
                        val intentHomePageActivity =
                            Intent(this@LaporanActivity, LaporanActivity::class.java)
                        intentHomePageActivity.putExtra(LoginPage.EXTRA_NAME, name)
                        intentHomePageActivity.putExtra(LoginPage.EXTRA_PASS, passwordlog)
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_USERNAME, username.toString())
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_PASS1, password)
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_EMAIL, email)
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_PHONE, handphone)
                        startActivity(intentHomePageActivity)
                    }
                    3 -> {
                        val intentHomePageActivity =
                            Intent(this@LaporanActivity, SettingActivity::class.java)
                        intentHomePageActivity.putExtra(LoginPage.EXTRA_NAME, name)
                        intentHomePageActivity.putExtra(LoginPage.EXTRA_PASS, passwordlog)
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_USERNAME, username.toString())
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_PASS1, password)
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_EMAIL, email)
                        intentHomePageActivity.putExtra(RegisterPageActivity.EXTRA_PHONE, handphone)
                        startActivity(intentHomePageActivity)
                    }
                }
            }
        }
    }
}