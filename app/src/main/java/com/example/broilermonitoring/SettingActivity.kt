package com.example.broilermonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.LoginPage.Companion.EXTRA_NAME
import com.example.broilermonitoring.LoginPage.Companion.EXTRA_PASS
import com.example.broilermonitoring.RegisterPageActivity.Companion.EXTRA_EMAIL
import com.example.broilermonitoring.RegisterPageActivity.Companion.EXTRA_PASS1
import com.example.broilermonitoring.RegisterPageActivity.Companion.EXTRA_PHONE
import com.example.broilermonitoring.RegisterPageActivity.Companion.EXTRA_USERNAME
import com.example.broilermonitoring.databinding.SettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: SettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNav = binding.bottomMenu
        val name = intent.getStringExtra(EXTRA_NAME)
        val passwordlog = intent.getStringExtra(EXTRA_PASS)
        val username = intent.getStringExtra(EXTRA_USERNAME)
        val password = intent.getStringExtra(EXTRA_PASS1)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val handphone = intent.getStringExtra(EXTRA_PHONE)

        with(binding){
            akun.setOnClickListener{
                val intentSettingBinding =
                    Intent(this@SettingActivity, AkunActivity::class.java)
                intentSettingBinding.putExtra(EXTRA_USERNAME, username)
                intentSettingBinding.putExtra(EXTRA_PASS1, password)
                intentSettingBinding.putExtra(EXTRA_EMAIL, email)
                intentSettingBinding.putExtra(EXTRA_PHONE, handphone)
                startActivity(intentSettingBinding)
            }
            password0.setOnClickListener{
                val intentSettingBinding =
                    Intent(this@SettingActivity, PasswordActivity::class.java)
                intentSettingBinding.putExtra(EXTRA_USERNAME, username)
                intentSettingBinding.putExtra(EXTRA_PASS1, password)
                intentSettingBinding.putExtra(EXTRA_EMAIL, email)
                intentSettingBinding.putExtra(EXTRA_PHONE, handphone)
                startActivity(intentSettingBinding)
            }
            panduan.setOnClickListener {
                val intentSettingBinding =
                    Intent(this@SettingActivity, PanduanAplikasiActivity::class.java)
                intentSettingBinding.putExtra(EXTRA_USERNAME, username)
                intentSettingBinding.putExtra(EXTRA_PASS1, password)
                intentSettingBinding.putExtra(EXTRA_EMAIL, email)
                intentSettingBinding.putExtra(EXTRA_PHONE, handphone)
                startActivity(intentSettingBinding)
            }
            keluar.setOnClickListener {
                val intentSettingBinding =
                    Intent(this@SettingActivity, LoginPage::class.java)
                intentSettingBinding.putExtra(EXTRA_USERNAME, username)
                intentSettingBinding.putExtra(EXTRA_PASS1, password)
                intentSettingBinding.putExtra(EXTRA_EMAIL, email)
                intentSettingBinding.putExtra(EXTRA_PHONE, handphone)
                startActivity(intentSettingBinding)
            }
            bottomNav.onItemSelected = {
                when(it){
                    0 -> {
                        val intentHomePageActivity =
                            Intent(this@SettingActivity, HomePageActivity::class.java)
                        intentHomePageActivity.putExtra(EXTRA_NAME, name)
                        intentHomePageActivity.putExtra(EXTRA_PASS, passwordlog)
                        intentHomePageActivity.putExtra(EXTRA_USERNAME, username.toString())
                        intentHomePageActivity.putExtra(EXTRA_PASS1, password)
                        intentHomePageActivity.putExtra(EXTRA_EMAIL, email)
                        intentHomePageActivity.putExtra(EXTRA_PHONE, handphone)
                        startActivity(intentHomePageActivity)
                    }
                    1 -> {
                        val intentHomePageActivity =
                            Intent(this@SettingActivity, DashboardActivity::class.java)
                        intentHomePageActivity.putExtra(EXTRA_NAME, name)
                        intentHomePageActivity.putExtra(EXTRA_PASS, passwordlog)
                        intentHomePageActivity.putExtra(EXTRA_USERNAME, username.toString())
                        intentHomePageActivity.putExtra(EXTRA_PASS1, password)
                        intentHomePageActivity.putExtra(EXTRA_EMAIL, email)
                        intentHomePageActivity.putExtra(EXTRA_PHONE, handphone)
                        startActivity(intentHomePageActivity)
                    }
                    2 -> {
                        val intentHomePageActivity =
                            Intent(this@SettingActivity, LaporanActivity::class.java)
                        intentHomePageActivity.putExtra(EXTRA_NAME, name)
                        intentHomePageActivity.putExtra(EXTRA_PASS, passwordlog)
                        intentHomePageActivity.putExtra(EXTRA_USERNAME, username.toString())
                        intentHomePageActivity.putExtra(EXTRA_PASS1, password)
                        intentHomePageActivity.putExtra(EXTRA_EMAIL, email)
                        intentHomePageActivity.putExtra(EXTRA_PHONE, handphone)
                        startActivity(intentHomePageActivity)
                    }
                    3 -> {
                        val intentHomePageActivity =
                            Intent(this@SettingActivity, SettingActivity::class.java)
                        intentHomePageActivity.putExtra(EXTRA_NAME, name)
                        intentHomePageActivity.putExtra(EXTRA_PASS, passwordlog)
                        intentHomePageActivity.putExtra(EXTRA_USERNAME, username.toString())
                        intentHomePageActivity.putExtra(EXTRA_PASS1, password)
                        intentHomePageActivity.putExtra(EXTRA_EMAIL, email)
                        intentHomePageActivity.putExtra(EXTRA_PHONE, handphone)
                        startActivity(intentHomePageActivity)
                    }
                }
            }
        }
    }
}