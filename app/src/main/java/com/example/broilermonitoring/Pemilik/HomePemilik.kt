package com.example.broilermonitoring.Pemilik

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.broilermonitoring.Klasifikasi
import com.example.broilermonitoring.Notifikasi
import com.example.broilermonitoring.databinding.PemilikHomeBinding
import com.example.broilermonitoring.model.Kandang
import com.example.broilermonitoring.model.Helper
import com.example.broilermonitoring.model.ResponseKandang
import com.example.broilermonitoring.service.ApiService
import com.example.broilermonitoring.service.KandangInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [Setting.newInstance] factory method to
 * create an instance of this fragment.
 */

class HomePemilik : Fragment() {
    private lateinit var binding: PemilikHomeBinding
    private lateinit var dataList: ArrayList<Kandang>
    private lateinit var namaKandang: ArrayList<String>
    private lateinit var helperToken: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

        binding = PemilikHomeBinding.inflate(layoutInflater)
        val view = binding.root

        val helper = Helper(requireContext())
        helperToken = helper.getToken().toString()

        val user = helper.getUser()
        val username = user?.username

        dataList = ArrayList<Kandang>()
        namaKandang = ArrayList<String>()

        //Data Nama Kandang untuk Spinner
        val customAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, namaKandang)
        customAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.kandang.adapter = customAdapter
        binding.kandang.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                //
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.kandang.setSelection(0)
            }
        }

        binding.tambahKandang.setOnClickListener{
            val intent = Intent(requireContext(), TambahKandang::class.java)
            startActivity(intent)
        }

        binding.daftarPeternak.setOnClickListener {
            val intent = Intent(requireContext(), DaftarPeternak::class.java)
            startActivity(intent)
        }
        binding.klasifikasi.setOnClickListener {
            // Handle the fragment transaction to change to InputPanen
            val klasifikasiFragment = Klasifikasi()  // Replace with the actual fragment class
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(com.example.broilermonitoring.R.id.nav_host_frag, klasifikasiFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
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
            // Handle the fragment transaction to change to InputPanen
            val notifikasiFragment = Notifikasi()  // Replace with the actual fragment class
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(com.example.broilermonitoring.R.id.nav_host_frag, notifikasiFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        binding.usernameUser.setText(username)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.kandang.setSelection(0)
    }

    override fun onResume() {
        super.onResume()
        fetchKandang(dataList, namaKandang, helperToken)
    }

    fun fetchKandang(dataList: ArrayList<Kandang>, namaKandang: ArrayList<String>, helperToken: String) {
        dataList.clear()
        namaKandang.clear()

        val token = "Bearer " + helperToken
        val kandang = ApiService().getInstance()
        val kandangApi = kandang.create(KandangInterface::class.java)
        val data = kandangApi.getKandang(token)

        data.enqueue(object : Callback<ResponseKandang> {
            override fun onResponse(
                call: Call<ResponseKandang>,
                response: Response<ResponseKandang>
            ) {
                val ResponseData = response.body()
                val datas = ResponseData?.data

                if(datas != null) {
                    for (data in datas) {
                        dataList.add(data)
                        namaKandang.add(data.namaKandang.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ResponseKandang>, t: Throwable) {
                Log.e("FETCH ERROR", "Error when Fetching Data", )
            }

        })
    }
}