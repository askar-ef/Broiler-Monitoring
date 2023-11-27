package com.example.broilermonitoring.Peternak

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.broilermonitoring.Dashboard
import com.example.broilermonitoring.Pemilik.Laporan
import com.example.broilermonitoring.Pemilik.HomePemilik
import com.example.broilermonitoring.Pengaturan
import com.example.broilermonitoring.R
import com.example.broilermonitoring.databinding.PeternakMainBinding

class MainPeternak : AppCompatActivity() {

    private lateinit var binding: PeternakMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PeternakMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomePemilik())

//        val name = intent.getStringExtra(LoginPage.EXTRA_NAME)
//        val passwordlog = intent.getStringExtra(LoginPage.EXTRA_PASS)
//        val username = intent.getStringExtra(RegisterPage.EXTRA_USERNAME)
//        val password = intent.getStringExtra(RegisterPage.EXTRA_PASS1)
//        val email = intent.getStringExtra(RegisterPage.EXTRA_EMAIL)
//        val handphone = intent.getStringExtra(RegisterPage.EXTRA_PHONE)

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        binding.bottomNavView.setOnItemSelectedListener {
            when(it){
                0 -> replaceFragment(HomePeternak())
                1 -> replaceFragment(Dashboard())
                2 -> replaceFragment(Laporan())
                3 -> replaceFragment(Pengaturan())
            }
            true
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
    private fun replaceFragment(fragment: androidx.fragment.app.Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_frag, fragment)
        transaction.commit()
    }
}