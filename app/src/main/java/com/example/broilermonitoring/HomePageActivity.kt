package com.example.broilermonitoring

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.broilermonitoring.LoginPage.Companion.EXTRA_NAME
import com.example.broilermonitoring.LoginPage.Companion.EXTRA_PASS
import com.example.broilermonitoring.RegisterPageActivity.Companion.EXTRA_EMAIL
import com.example.broilermonitoring.RegisterPageActivity.Companion.EXTRA_PASS1
import com.example.broilermonitoring.RegisterPageActivity.Companion.EXTRA_PHONE
import com.example.broilermonitoring.RegisterPageActivity.Companion.EXTRA_USERNAME
import com.example.broilermonitoring.databinding.HomePageBinding
import me.ibrahimsn.lib.SmoothBottomBar

class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: HomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val passwordlog = intent.getStringExtra(EXTRA_PASS)
        val username = intent.getStringExtra(EXTRA_USERNAME)
        val password = intent.getStringExtra(EXTRA_PASS1)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val handphone = intent.getStringExtra(EXTRA_PHONE)

        val bottomNav = binding.bottomMenu

        val spinner = findViewById<Spinner>(R.id.kandang)
        val customAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.kandang,
            R.layout.spinner_item
        )

        customAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = customAdapter

        with(binding) {
            usernameUser.text = "$name"
            daftarPeternak.setOnClickListener {
                val intentHomePageActivity =
                    Intent(this@HomePageActivity, DaftarPeternakActivity::class.java)
                intentHomePageActivity.putExtra(EXTRA_NAME, name)
                intentHomePageActivity.putExtra(EXTRA_PASS, passwordlog)
                intentHomePageActivity.putExtra(EXTRA_USERNAME, username.toString())
                intentHomePageActivity.putExtra(EXTRA_PASS1, password)
                intentHomePageActivity.putExtra(EXTRA_EMAIL, email)
                intentHomePageActivity.putExtra(EXTRA_PHONE, handphone)
                startActivity(intentHomePageActivity)
            }
            klasifikasi.setOnClickListener {
                val intentHomePageActivity =
                    Intent(this@HomePageActivity, KlasifikasiActivity::class.java)
                intentHomePageActivity.putExtra(EXTRA_NAME, name)
                intentHomePageActivity.putExtra(EXTRA_PASS, passwordlog)
                intentHomePageActivity.putExtra(EXTRA_USERNAME, username.toString())
                intentHomePageActivity.putExtra(EXTRA_PASS1, password)
                intentHomePageActivity.putExtra(EXTRA_EMAIL, email)
                intentHomePageActivity.putExtra(EXTRA_PHONE, handphone)
                startActivity(intentHomePageActivity)
            }
            forcasting.setOnClickListener {
                val intentHomePageActivity =
                    Intent(this@HomePageActivity, ForecastingActivity::class.java)
                intentHomePageActivity.putExtra(EXTRA_NAME, name)
                intentHomePageActivity.putExtra(EXTRA_PASS, passwordlog)
                intentHomePageActivity.putExtra(EXTRA_USERNAME, username.toString())
                intentHomePageActivity.putExtra(EXTRA_PASS1, password)
                intentHomePageActivity.putExtra(EXTRA_EMAIL, email)
                intentHomePageActivity.putExtra(EXTRA_PHONE, handphone)
                startActivity(intentHomePageActivity)
            }
            history.setOnClickListener {
                val intentHomePageActivity =
                    Intent(this@HomePageActivity, HistoryPanenActivity::class.java)
                intentHomePageActivity.putExtra(EXTRA_NAME, name)
                intentHomePageActivity.putExtra(EXTRA_PASS, passwordlog)
                intentHomePageActivity.putExtra(EXTRA_USERNAME, username.toString())
                intentHomePageActivity.putExtra(EXTRA_PASS1, password)
                intentHomePageActivity.putExtra(EXTRA_EMAIL, email)
                intentHomePageActivity.putExtra(EXTRA_PHONE, handphone)
                startActivity(intentHomePageActivity)
            }
            notifikasi.setOnClickListener {
                val intentHomePageActivity =
                    Intent(this@HomePageActivity, NotifikasiActivity::class.java)
                intentHomePageActivity.putExtra(EXTRA_NAME, name)
                intentHomePageActivity.putExtra(EXTRA_PASS, passwordlog)
                intentHomePageActivity.putExtra(EXTRA_USERNAME, username.toString())
                intentHomePageActivity.putExtra(EXTRA_PASS1, password)
                intentHomePageActivity.putExtra(EXTRA_EMAIL, email)
                intentHomePageActivity.putExtra(EXTRA_PHONE, handphone)
                startActivity(intentHomePageActivity)
            }
            bottomNav.setOnItemSelectedListener  {
                when (it) {
                    0 -> {
                        val intentHomePageActivity =
                            Intent(this@HomePageActivity, HomePageActivity::class.java)
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
                            Intent(this@HomePageActivity, DashboardActivity::class.java)
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
                            Intent(this@HomePageActivity, LaporanActivity::class.java)
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
                            Intent(this@HomePageActivity, SettingActivity::class.java)
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
