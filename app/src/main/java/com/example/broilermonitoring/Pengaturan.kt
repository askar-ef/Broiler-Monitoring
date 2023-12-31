package com.example.broilermonitoring

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.broilermonitoring.databinding.FragmentPengaturanBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Pengaturan.newInstance] factory method to
 * create an instance of this fragment.
 */
class Pengaturan : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentPengaturanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPengaturanBinding.inflate(inflater, container, false)
        val view = binding.root

        with(binding){
            akun.setOnClickListener {
                // Handle the fragment transaction to change to InputPanen
                val akunFragment = Akun()  // Replace with the actual fragment class
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.nav_host_frag, akunFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
            password.setOnClickListener {
                // Handle the fragment transaction to change to InputPanen
                val passwordFragment = Password()  // Replace with the actual fragment class
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.nav_host_frag, passwordFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
            panduan.setOnClickListener {
                // Handle the fragment transaction to change to InputPanen
                val panduanFragment = PanduanAplikasi()  // Replace with the actual fragment class
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.nav_host_frag, panduanFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Pengaturan.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Pengaturan().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}