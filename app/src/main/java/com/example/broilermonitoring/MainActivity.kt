package com.example.broilermonitoring

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.broilermonitoring.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(LoginPage.EXTRA_NAME)
        val passwordlog = intent.getStringExtra(LoginPage.EXTRA_PASS)
        val username = intent.getStringExtra(RegisterPage.EXTRA_USERNAME)
        val password = intent.getStringExtra(RegisterPage.EXTRA_PASS1)
        val email = intent.getStringExtra(RegisterPage.EXTRA_EMAIL)
        val handphone = intent.getStringExtra(RegisterPage.EXTRA_PHONE)

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        binding.bottomMenu.setOnItemSelectedListener {
            when (it) {
                R.id.navigation_home -> {
                    fragmentTransaction.replace(R.id.nav_host_frag, Home())
                }
                R.id.navigation_dashboard -> {
                    fragmentTransaction.replace(R.id.nav_host_frag, Dashboard())
                }
                R.id.navigation_laporan -> {
                    fragmentTransaction.replace(R.id.nav_host_frag, Laporan())
                }
                R.id.navigation_setting -> {
                    fragmentTransaction.replace(R.id.nav_host_frag, Setting())
                }
            }
            fragmentTransaction.commit()
        }

//        val navController = findNavController(R.id.nav_host_fragment_activity_main2)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }
}