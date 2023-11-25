package com.example.broilermonitoring.Peternak

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.broilermonitoring.FetchDataCoroutine
import com.example.broilermonitoring.Klasifikasi
import com.example.broilermonitoring.Notifikasi
import com.example.broilermonitoring.databinding.FragmentHomePeternakBinding
import com.example.broilermonitoring.model.DataItem
import com.example.broilermonitoring.model.Helper
import com.example.broilermonitoring.model.ResponseKandang
import com.example.broilermonitoring.service.ApiService
import com.example.broilermonitoring.service.KandangInterface
import retrofit2.Call
import retrofit2.Callback

/**
 * A simple [Fragment] subclass.
 * Use the [HomePeternak.newInstance] factory method to
 * create an instance of this fragment.
 */

class HomePeternak : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentHomePeternakBinding
    private lateinit var DataList:ArrayList<DataItem>
    private lateinit var KandangList:ArrayList<String>
    private lateinit var FetchData: FetchDataCoroutine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomePeternakBinding.inflate(inflater, container, false)
        val view=binding.root

        DataList = arrayListOf<DataItem>()
        KandangList = arrayListOf<String>()

//        getKandang()
        val Token="Bearer "+ Helper(requireContext()).getToken().toString()
//        val IdAnak="1"
        val Kandang= ApiService().getInstance()
        val KandangApi=Kandang.create(KandangInterface::class.java)
        val call= KandangApi.getKandangPerAnak(Token)

        call.enqueue(object : Callback<ResponseKandang> {
            override fun onResponse(call: Call<ResponseKandang>, response: retrofit2.Response<ResponseKandang>) {
                val ResponseData = response.body()
                val Datas = ResponseData?.data
                if (Datas != null) {
                    for (data in Datas) {
                        DataList.add(data)
                        KandangList.add(data?.namaKandang.toString())
                    }
                }
                Log.e("Response", ResponseData.toString())
            }
            override fun onFailure(call: Call<ResponseKandang>, t: Throwable) {
                Log.e("API Call", "Failure: ${t.message}")
            }
        })
        with(binding){
            val kandangAdapter =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_dropdown_item, KandangList)
            kandangAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            kandang.adapter=kandangAdapter

            // Add click listener to the "btnInputPanen" button
            btnInputPanen.setOnClickListener {
                // Handle the fragment transaction to change to InputPanen
                val inputPanenFragment = InputPanen()  // Replace with the actual fragment class
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(com.example.broilermonitoring.R.id.nav_host_frag, inputPanenFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

            btnKlasifikasi.setOnClickListener {
                // Handle the fragment transaction to change to InputPanen
                val klasifikasiFragment = Klasifikasi()  // Replace with the actual fragment class
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(com.example.broilermonitoring.R.id.nav_host_frag, klasifikasiFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

            btnInputHarian.setOnClickListener {
                // Handle the fragment transaction to change to InputPanen
                val inputHarianFragment = InputHarian()  // Replace with the actual fragment class
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(com.example.broilermonitoring.R.id.nav_host_frag, inputHarianFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

            btnNotif.setOnClickListener {
                // Handle the fragment transaction to change to InputPanen
                val notifikasiFragment = Notifikasi()  // Replace with the actual fragment class
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(com.example.broilermonitoring.R.id.nav_host_frag, notifikasiFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

        }
        binding.kandang.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.kandang.setSelection(0)
            }
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val token="Bearer "+ Helper(requireContext()).getToken()
        val id_kandang= Helper(requireContext()).getIdKandang()

        FetchData= FetchDataCoroutine(token, id_kandang)
        FetchData.startFetching()
    }

    override fun onResume() {
        super.onResume()
        with(binding){
            statAmonia.setText(FetchData.getAmoniak())
            statKelembaban.setText(FetchData.getKelembaban())
            statSuhu.setText(FetchData.getSuhu())
        }
    }

    override fun onStop() {
        super.onStop()
        FetchData.stop()
    }

}