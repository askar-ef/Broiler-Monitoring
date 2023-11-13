package com.example.broilermonitoring

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.TextView
import com.example.broilermonitoring.databinding.DashboardBinding

class DashboardActivity : AppCompatActivity() {
    internal var status = 0
    private val handler = Handler()
    private lateinit var textView: TextView
    private lateinit var binding: DashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNav = binding.bottomMenu
        val name = intent.getStringExtra(LoginPage.EXTRA_NAME)
        val passwordlog = intent.getStringExtra(LoginPage.EXTRA_PASS)
        val username = intent.getStringExtra(RegisterPageActivity.EXTRA_USERNAME)
        val password = intent.getStringExtra(RegisterPageActivity.EXTRA_PASS1)
        val email = intent.getStringExtra(RegisterPageActivity.EXTRA_EMAIL)
        val handphone = intent.getStringExtra(RegisterPageActivity.EXTRA_PHONE)

        val resources = resources
        val drawable = resources.getDrawable(R.drawable.progress)
        val progressBar: ProgressBar = findViewById(R.id.progress_suhu)
        progressBar.progress = 0
        progressBar.secondaryProgress = 100
        progressBar.max = 100
        progressBar.progressDrawable = drawable
        textView = findViewById(R.id.suhu)
        Thread {
            while (status < 100) {
                status += 1
                handler.post {
                    progressBar.progress = status
                    textView.text = String.format("%d%%", status)
                }
                try {
                    Thread.sleep(16)
                }
                catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
        with(binding){
            bottomNav.onItemSelected = {
                when(it){
                    0 -> {
                        val intentHomePageActivity =
                            Intent(this@DashboardActivity, HomePageActivity::class.java)
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
                            Intent(this@DashboardActivity, DashboardActivity::class.java)
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
                            Intent(this@DashboardActivity, LaporanActivity::class.java)
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
                            Intent(this@DashboardActivity, SettingActivity::class.java)
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