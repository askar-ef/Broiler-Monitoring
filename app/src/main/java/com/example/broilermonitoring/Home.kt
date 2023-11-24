package com.example.broilermonitoring

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.broilermonitoring.databinding.FragmentHomeBinding
import com.example.broilermonitoring.model.DataItem
import com.example.broilermonitoring.model.Helper
import com.example.broilermonitoring.model.ResponseKandang
import com.example.broilermonitoring.service.ApiService
import com.example.broilermonitoring.service.KandangInterface
import retrofit2.Call
import retrofit2.Callback

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */

class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentHomeBinding
    private lateinit var DataList:ArrayList<DataItem>
    private lateinit var KandangList:ArrayList<String>
    private lateinit var FetchData:FetchDataCoroutine

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
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        val view=binding.root

        DataList = arrayListOf<DataItem>()
        KandangList = arrayListOf<String>()

//        getKandang()
        val Token="Bearer "+Helper(requireContext()).getToken().toString()
//        val IdAnak="1"
        val Kandang= ApiService().getInstance()
        val KandangApi=Kandang.create(KandangInterface::class.java)
        val call= KandangApi.getKandangPerAnak(Token)

        call.enqueue(object :Callback<ResponseKandang>{
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
            val kandangAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_dropdown_item,KandangList)
            kandangAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            kandang.adapter=kandangAdapter

            // Add click listener to the "btnInputPanen" button
            btnInputPanen.setOnClickListener {
                // Handle the fragment transaction to change to InputPanen
                val inputPanenFragment = InputPanen()  // Replace with the actual fragment class
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.nav_host_frag, inputPanenFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

            btnKlasifikasi.setOnClickListener {
                // Handle the fragment transaction to change to InputPanen
                val klasifikasiFragment = Klasifikasi()  // Replace with the actual fragment class
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.nav_host_frag, klasifikasiFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

            btnInputHarian.setOnClickListener {
                // Handle the fragment transaction to change to InputPanen
                val inputHarianFragment = InputHarian()  // Replace with the actual fragment class
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.nav_host_frag, inputHarianFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

            btnNotif.setOnClickListener {
                // Handle the fragment transaction to change to InputPanen
                val notifikasiFragment = Notifikasi()  // Replace with the actual fragment class
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.nav_host_frag, notifikasiFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

        }
        binding.kandang.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Di sini Anda dapat melakukan sesuatu ketika item dipilih.
                val selectedItem = KandangList[position]
                val idKandang=Helper(requireContext()).saveIdKandang(DataList[position].id!!.toInt())
                Toast.makeText(requireContext(), "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Implementasi ini akan dipanggil jika tidak ada item yang dipilih.
            }
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val token="Bearer "+Helper(requireContext()).getToken()
        val id_kandang=Helper(requireContext()).getIdKandang()

        FetchData=FetchDataCoroutine(token,id_kandang)
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}