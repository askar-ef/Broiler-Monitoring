package com.example.broilermonitoring.Peternak

import android.R
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
import com.example.broilermonitoring.databinding.PeternakHomeBinding
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
    private lateinit var binding: PeternakHomeBinding
    private lateinit var DataList:ArrayList<DataItem>
    private lateinit var KandangList:ArrayList<String>
    private lateinit var FetchData: FetchDataCoroutine
    private val refreshInterval = 1000 // 1 seconds
    private val handler = Handler(Looper.getMainLooper())
    private val refreshRunnable = object : Runnable {
        override fun run() {
            fetchData()
            handler.postDelayed(this, refreshInterval.toLong())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= PeternakHomeBinding.inflate(inflater, container, false)
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
                binding.kandang.setSelection(1)
            }
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        startAutoRefresh()
    }

    override fun onResume() {
        super.onResume()
//        with(binding){
//            statAmonia.setText(FetchData.getAmoniakv().toString())
//            statKelembaban.setText(FetchData.getKelembabanv().toString())
//            statSuhu.setText(FetchData.getSuhuv().toString())
//
//            Log.e("suhu",FetchData.getSuhuv().toString())
//        }
    }


    override fun onStop() {
        super.onStop()
        stopAutoRefresh()
    }

    private fun startAutoRefresh() {
        val token = "Bearer " + Helper(requireContext()).getToken()
        val idKandang = 1 // Change this to your actual logic for getting the ID
        FetchData = FetchDataCoroutine(token, idKandang)
        FetchData.startFetching()
        handler.postDelayed(refreshRunnable, refreshInterval.toLong())
    }

    private fun stopAutoRefresh() {
        handler.removeCallbacks(refreshRunnable)
        FetchData.stop()
    }

    private fun fetchData() {
        // Implement your data fetching logic here
        // Update UI with the fetched data
        // For example:
        with(binding) {
            statAmonia.text = FetchData.getAmoniakv().toString() + "%"
            if (FetchData.getAmoniakv() >= 25 && FetchData.getAmoniakv()<27){

                statAmonia.setTextColor(resources.getColor(com.example.broilermonitoring.R.color.waspada))
            }else if (FetchData.getAmoniakv()>=27) {
                statAmonia.setTextColor(resources.getColor(com.example.broilermonitoring.R.color.bahaya))
            }else{
                statAmonia.setTextColor(resources.getColor(com.example.broilermonitoring.R.color.aman))
            }
            statKelembaban.text = FetchData.getKelembabanv().toString() + "%"
            if (FetchData.getKelembabanv() >= 25 && FetchData.getAmoniakv()<27){

                statKelembaban.setTextColor(resources.getColor(com.example.broilermonitoring.R.color.waspada))
            }else if (FetchData.getKelembabanv()>=27) {
                statKelembaban.setTextColor(resources.getColor(com.example.broilermonitoring.R.color.bahaya))
            }else{
                statKelembaban.setTextColor(resources.getColor(com.example.broilermonitoring.R.color.aman))
            }
            statSuhu.text = FetchData.getSuhuv().toString() + "°"
            if (FetchData.getSuhuv() >= 25 && FetchData.getAmoniakv()<27){

                statSuhu.setTextColor(resources.getColor(com.example.broilermonitoring.R.color.waspada))
            }else if (FetchData.getSuhuv()>=27) {
                statSuhu.setTextColor(resources.getColor(com.example.broilermonitoring.R.color.bahaya))
            }else{
                statSuhu.setTextColor(resources.getColor(com.example.broilermonitoring.R.color.aman))
            }
        }
    }

}