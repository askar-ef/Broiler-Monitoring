package com.example.broilermonitoring.Peternak

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.broilermonitoring.R
import com.example.broilermonitoring.databinding.PeternakInputPanenBinding
import com.example.broilermonitoring.model.Helper
import com.example.broilermonitoring.model.Post.PopulationResponse
import com.example.broilermonitoring.service.ApiService
import com.example.broilermonitoring.service.PopulationInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InputPanen.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputPanen : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: PeternakInputPanenBinding

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
        binding = PeternakInputPanenBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        val token="Bearer "+Helper(requireContext()).getToken()
        val id_kandang=Helper(requireContext()).getIdKandang()
        val Api=ApiService().getInstance().create(PopulationInterface::class.java)


        with(binding){
            panenBackbutton.setOnClickListener {
                // Handle the fragment transaction to change to HomePeternak
                val homeFragment = HomePeternak()  // Replace with the actual fragment class
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.nav_host_frag, homeFragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
            simpanButton.setOnClickListener {
                Api.PostPopulation(token,id_kandang,inputPopulasiBaru.text.toString().toInt()).enqueue(object :Callback<PopulationResponse>{
                    override fun onResponse(
                        call: Call<PopulationResponse>,
                        response: Response<PopulationResponse>
                    ) {
                        Log.d("done",response.message())
                    }
                    override fun onFailure(call: Call<PopulationResponse>, t: Throwable) {
                        Log.e("fail",t.message.toString())
                        Log.e("token",token)
                        Log.e("id_kandang",id_kandang.toString())
                    }

                })
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
         * @return A new instance of fragment InputPanen.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InputPanen().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}