package com.example.broilermonitoring.Pemilik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.Dashboard
import com.example.broilermonitoring.Pengaturan
import com.example.broilermonitoring.R
import com.example.broilermonitoring.databinding.PemilikMainBinding

class MainPemilik : AppCompatActivity() {
    private lateinit var binding: PemilikMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PemilikMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomePemilik())

        binding.bottomNavView.setItemSelected(R.id.navigation_home)

        binding.bottomNavView.setOnItemSelectedListener {
            when(it){
                R.id.navigation_home -> replaceFragment(HomePemilik())
                R.id.navigation_dashboard -> replaceFragment(Dashboard())
                R.id.navigation_laporan -> replaceFragment(Laporan())
                R.id.navigation_setting -> replaceFragment(Pengaturan())
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