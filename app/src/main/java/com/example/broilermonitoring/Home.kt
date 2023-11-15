package com.example.broilermonitoring

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.broilermonitoring.databinding.HomePageBinding
import com.example.broilermonitoring.LoginPage.Companion.EXTRA_NAME
import com.example.broilermonitoring.LoginPage.Companion.EXTRA_PASS
import com.example.broilermonitoring.RegisterPage.Companion.EXTRA_EMAIL
import com.example.broilermonitoring.RegisterPage.Companion.EXTRA_PASS1
import com.example.broilermonitoring.RegisterPage.Companion.EXTRA_PHONE
import com.example.broilermonitoring.RegisterPage.Companion.EXTRA_USERNAME
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : Fragment() {
    private lateinit var binding: HomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomePageBinding.inflate(layoutInflater)
        val view = binding.root

        val name = arguments?.getString(EXTRA_NAME)
        val passwordlog = arguments?.getString(EXTRA_PASS)
        val username = arguments?.getString(EXTRA_USERNAME)
        val password = arguments?.getString(EXTRA_PASS1)
        val email = arguments?.getString(EXTRA_EMAIL)
        val handphone = arguments?.getString(EXTRA_PHONE)
        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottom_menu)
        val spinner = view.findViewById<Spinner>(R.id.kandang)
        val customAdapter = ArrayAdapter.createFromResource(requireContext(),
            R.array.kandang,
            R.layout.spinner_item
        )

        customAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = customAdapter

        with(binding) {
            usernameUser.text = "$name"
            daftarPeternak.setOnClickListener {
                val intentHomePageActivity =
                    Intent(requireContext(), DaftarPeternak::class.java)
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
                    Intent(requireContext(), Klasifikasi::class.java)
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
                    Intent(requireContext(), Forecasting::class.java)
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
                    Intent(requireContext(), HistoryPanen::class.java)
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
                    Intent(requireContext(), Notifikasi::class.java)
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomePageBinding.inflate(layoutInflater)
        val view = binding.root
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}