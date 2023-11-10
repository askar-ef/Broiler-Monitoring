package com.example.broilermonitoring

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.broilermonitoring.databinding.FragmentHomeBinding
import com.example.broilermonitoring.model.DataItem
import com.example.broilermonitoring.model.Helper
import com.example.broilermonitoring.model.Response
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

        getKandang()

        with(binding){
            val kandangAdapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_expandable_list_item_1,KandangList)
            kandangAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            kandang.adapter=kandangAdapter

        }
        return view
    }

    private fun getKandang() {
//        val IdAnak=Helper(requireContext()).getId().toString()
        val IdAnak="1"
        val Kandang= ApiService().getInstance()
        val KandangApi=Kandang.create(KandangInterface::class.java)

        KandangApi.getKandangPerAnak(IdAnak).enqueue(object :Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val ResponseData = response.body()
                val Datas = ResponseData?.data
                if (Datas != null) {
                    for (data in Datas) {
                        DataList.add(data)
                        KandangList.add(data?.namaKandang.toString())
                    }
                }
                Log.e("Response", "Response body is null")
            }
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e("API Call", "Failure: ${t.message}")
            }
        })
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