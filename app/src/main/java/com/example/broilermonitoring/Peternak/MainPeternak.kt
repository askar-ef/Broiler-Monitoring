package com.example.broilermonitoring.Peternak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broilermonitoring.Dashboard
import com.example.broilermonitoring.Pengaturan
import com.example.broilermonitoring.R
import com.example.broilermonitoring.databinding.PeternakMainBinding

class MainPeternak : AppCompatActivity() {

    lateinit var binding:PeternakMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PeternakMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomePeternak())
        binding.bottomNavView.setItemSelected(R.id.nav_home)

        binding.bottomNavView.setOnItemSelectedListener {
            when(it){
                R.id.nav_home -> replaceFragment(HomePeternak())
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