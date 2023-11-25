package com.example.broilermonitoring.Peternak

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.broilermonitoring.R
import com.example.broilermonitoring.databinding.FragmentInputHarianBinding
import com.example.broilermonitoring.model.Helper
import com.example.broilermonitoring.model.Post.DataKandangResponse
import com.example.broilermonitoring.model.Post.DataKematianResponse
import com.example.broilermonitoring.service.ApiService
import com.example.broilermonitoring.service.DataKandangInterface
import com.example.broilermonitoring.service.DataKematianInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InputHarian.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputHarian : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentInputHarianBinding
    private var jamKematian =0
    private var jumlahKematian = 0

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
        binding= FragmentInputHarianBinding.inflate(layoutInflater,container,false)
//        binding = FragmentInputHarianBinding.inflate(inflater, container, false)
        val view=binding.root
        return view


        with(binding){
            btnLapor.setOnClickListener {
                val pakan=inputPakan.text.toString().toInt()
                val minum=inputMinum.text.toString().toInt()
                val bobot=inputBobot.text.toString().toInt()
//masih percobaan
                val id_kandang=1
                val api=ApiService().getInstance()
                val apiInput=api.create(DataKandangInterface::class.java)
                val token="Bearer " + Helper(requireContext()).getToken().toString()
                val inputHarian=apiInput.postData(token,pakan,id_kandang,minum,bobot)
                inputHarian.enqueue(object :Callback<DataKandangResponse>{
                    override fun onResponse(
                        call: Call<DataKandangResponse>,
                        response: Response<DataKandangResponse>
                    ) {
                        if (response.isSuccessful){
                            val responseBody=response.body()
                            val responseData=responseBody?.message
                            Log.e("response",responseData.toString())
                        }
                        else{
                            Log.e("response",response.raw().message)
                            Log.e("token", token)
                        }

                    }

                    override fun onFailure(call: Call<DataKandangResponse>, t: Throwable) {
                        Log.e("Failure",t.message.toString()+t.cause)
                    }
                })

            }
            inputJumlahKematian.setText(0)
            val waktu=resources.getStringArray(R.array.jam)
            val waktuAdapter=ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item,waktu)
            waktuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerWaktu.adapter=waktuAdapter
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        with(binding){
            btnTambahKematian.setOnClickListener {
                jumlahKematian += 1
                inputJumlahKematian.setText(jumlahKematian.toString())
            }
            btnKurangiKematian.setOnClickListener {
                if (jumlahKematian != 0){
                    jumlahKematian -= 1
                    inputJumlahKematian.setText(jumlahKematian.toString())
                }
            }

            spinnerWaktu.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    jamKematian=999
                }
            }

            val token="Bearer "+Helper(requireContext()).getToken().toString()

            val api=ApiService().getInstance()
            val apiKematian=api.create(DataKematianInterface::class.java)

            btnLaporkanKematian.setOnClickListener {
                var jamKematianData = binding.spinnerWaktu.selectedItem.toString()
                jamKematianData = jamKematianData.substring(0, 2)

                jumlahKematian = inputJumlahKematian.text.toString().toInt()
                if(jamKematianData[0] == '0') {
                    jamKematianData = jamKematianData[1].toString()
                    jamKematian = Integer.parseInt(jamKematianData)
                } else{
                    jamKematian = Integer.parseInt(jamKematianData)
                }

                if (jamKematian <=23 && jamKematian>=0){
                    apiKematian.postDataKematian(token,jamKematian,1, jumlahKematian)
                        .enqueue(object :Callback<DataKematianResponse>{
                            override fun onResponse(
                                call: Call<DataKematianResponse>,
                                response: Response<DataKematianResponse>
                            ) {
                                if (response.isSuccessful){
                                    val responseData=response.body()
                                    Log.i("response",responseData?.message.toString())
                                }else{
                                    Log.e("response",response.message())
                                }
                            }
                            override fun onFailure(call: Call<DataKematianResponse>, t: Throwable) {
                                Log.e("Failure",t.message.toString())
                            }
                        })
                }
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InputHarian.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InputHarian().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}