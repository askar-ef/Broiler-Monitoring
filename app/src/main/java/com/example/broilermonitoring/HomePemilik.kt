package com.example.broilermonitoring

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
//import com.example.broilermonitoring.LoginPage.Companion.EXTRA_NAME
//import com.example.broilermonitoring.LoginPage.Companion.EXTRA_PASS
//import com.example.broilermonitoring.RegisterPage.Companion.EXTRA_EMAIL
//import com.example.broilermonitoring.RegisterPage.Companion.EXTRA_PASS1
//import com.example.broilermonitoring.RegisterPage.Companion.EXTRA_PHONE
//import com.example.broilermonitoring.RegisterPage.Companion.EXTRA_USERNAME
import android.content.Intent
import com.example.broilermonitoring.databinding.FragmentHomePemilikBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

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
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePemilik().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}