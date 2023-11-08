package com.example.broilermonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavView.setItemSelected(R.id.nav_home)

        binding.bottomNavView.setOnItemSelectedListener {
            when(it){
                R.id.nav_home -> replaceFragment(Home())
                R.id.nav_dashboard -> replaceFragment(Dashboard())
                R.id.nav_reports -> replaceFragment(InputHarian())
                R.id.nav_settings -> replaceFragment(Pengaturan())
            }
            true
        }
    }

    private fun replaceFragment(fragment: androidx.fragment.app.Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_frag, fragment)
        transaction.commit()
    }
}