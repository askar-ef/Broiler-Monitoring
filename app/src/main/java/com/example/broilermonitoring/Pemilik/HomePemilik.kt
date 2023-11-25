package com.example.broilermonitoring.Pemilik

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.broilermonitoring.Klasifikasi
import com.example.broilermonitoring.Notifikasi
import com.example.broilermonitoring.R
import com.example.broilermonitoring.databinding.FragmentHomePemilikBinding

/**
 * A simple [Fragment] subclass.
 * Use the [Setting.newInstance] factory method to
 * create an instance of this fragment.
 */

class HomePemilik : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentHomePemilikBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

        binding = FragmentHomePemilikBinding.inflate(layoutInflater)
        val view = binding.root

//        val name = arguments?.getString(EXTRA_NAME)
//        val passwordlog = arguments?.getString(EXTRA_PASS)
//        val username = arguments?.getString(EXTRA_USERNAME)
//        val password = arguments?.getString(EXTRA_PASS1)
//        val email = arguments?.getString(EXTRA_EMAIL)
//        val handphone = arguments?.getString(EXTRA_PHONE)
//        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottom_menu)
        val spinner = view.findViewById<Spinner>(R.id.kandang)
        val customAdapter = ArrayAdapter.createFromResource(
            requireContext(),
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