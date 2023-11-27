package com.example.broilermonitoring.Pemilik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
//import com.example.broilermonitoring.login.LoginPage.Companion.EXTRA_NAME
//import com.example.broilermonitoring.login.LoginPage.Companion.EXTRA_PASS
//import com.example.broilermonitoring.register.RegisterPage.Companion.EXTRA_EMAIL
//import com.example.broilermonitoring.register.RegisterPage.Companion.EXTRA_PASS1
//import com.example.broilermonitoring.register.RegisterPage.Companion.EXTRA_PHONE
//import com.example.broilermonitoring.register.RegisterPage.Companion.EXTRA_USERNAME
import android.content.Intent
import com.example.broilermonitoring.HistoryPanen
import com.example.broilermonitoring.Klasifikasi
import com.example.broilermonitoring.Notifikasi
import com.example.broilermonitoring.databinding.PemilikHomeBinding
import com.example.broilermonitoring.R


class HomePemilik : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: PemilikHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

        binding = PemilikHomeBinding.inflate(layoutInflater)
        val view = binding.root

//        val name = arguments?.getString(EXTRA_NAME)
//        val passwordlog = arguments?.getString(EXTRA_PASS)
//        val username = arguments?.getString(EXTRA_USERNAME)
//        val password = arguments?.getString(EXTRA_PASS1)
//        val email = arguments?.getString(EXTRA_EMAIL)
//        val handphone = arguments?.getString(EXTRA_PHONE)
//        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottom_menu)
        val spinner = view.findViewById<Spinner>(R.id.kandang)
        val customAdapter = ArrayAdapter.createFromResource(requireContext(),
            R.array.kandang, android.R.layout.simple_spinner_item
        )

        customAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = customAdapter

        binding.tambahKandang.setOnClickListener{
            val intent = Intent(requireContext(), TambahKandang::class.java)
            startActivity(intent)
        }

        binding.daftarPeternak.setOnClickListener {
            val intent = Intent(requireContext(), DaftarPeternak::class.java)
            startActivity(intent)
        }
        binding.klasifikasi.setOnClickListener {
            val intent = Intent(requireContext(), Klasifikasi::class.java)
            startActivity(intent)
        }
        binding.forcasting.setOnClickListener {
            val intent = Intent(requireContext(), Forecasting::class.java)
            startActivity(intent)
        }
        binding.history.setOnClickListener {
            val intent = Intent(requireContext(), HistoryPanen::class.java)
            startActivity(intent)
        }
        binding.notifikasi.setOnClickListener {
            val intent = Intent(requireContext(), Notifikasi::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}