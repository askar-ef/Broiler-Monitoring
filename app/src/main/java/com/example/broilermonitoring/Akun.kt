package com.example.broilermonitoring

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.broilermonitoring.databinding.FragmentAkunBinding
import com.example.broilermonitoring.model.Helper
import com.example.broilermonitoring.model.Profile
import com.example.broilermonitoring.model.ProfileResponse
import com.example.broilermonitoring.service.ApiService
import com.example.broilermonitoring.service.UserInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Akun.newInstance] factory method to
 * create an instance of this fragment.
 */
class Akun : Fragment() {
    private lateinit var binding: FragmentAkunBinding
    private lateinit var token: String
    private var user: Profile = Profile()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

        binding = FragmentAkunBinding.inflate(layoutInflater)
        val view = binding.root

        val helper = Helper(requireContext())
        token = "Bearer " + helper.getToken().toString()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAkunBinding.inflate(inflater)

        //Fetch data
        fetchData()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun fetchData() {
        val apiService = ApiService().getInstance()
        val profileApi = apiService.create(UserInterface::class.java)

        val data = profileApi.profile(token)

        data.enqueue(object : Callback<ProfileResponse> {
            override fun onResponse(
                call: Call<ProfileResponse>,
                response: Response<ProfileResponse>
            ) {
                val responseData = response.body()
                val result = responseData?.data

                if(result != null) {
                    user = result

                    //Tampilin data
                    binding.fullName.text = user.namaLengkap
                    binding.name.text = user.namaLengkap
                    binding.txtPhoneNumber.text = user.noTelepon
                    binding.txtRole.text = user.status
                    binding.txtEmail.text = user.email
                }
            }

            override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
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
         * @return A new instance of fragment Akun.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Akun().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}