package com.example.broilermonitoring.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.broilermonitoring.Pemilik.MainPemilik
import com.example.broilermonitoring.Peternak.MainPeternak
import com.example.broilermonitoring.databinding.ActivityLoginSuccessBinding
import com.example.broilermonitoring.model.Helper
import com.example.broilermonitoring.model.ProfileResponse
import com.example.broilermonitoring.model.ResponseKandang
import com.example.broilermonitoring.service.ApiService
import com.example.broilermonitoring.service.UserInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginSuccess : AppCompatActivity() {
    private lateinit var binding: ActivityLoginSuccessBinding
    private lateinit var userStatus: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Check Status apakah owner atau peternak
        val helper = Helper(this@LoginSuccess)
        val helperToken = helper.getToken().toString()

        val token = "Bearer " + helperToken
        val user = ApiService().getInstance()
        val userApi = user.create(UserInterface::class.java)
        val data = userApi.profile(token)

        data.enqueue(object : Callback<ProfileResponse> {
            override fun onResponse(
                call: Call<ProfileResponse>,
                response: Response<ProfileResponse>
            ) {
                val ResponseData = response.body()
                val data = ResponseData?.data

                if(data != null) {
                    helper.saveUser(data)
                    userStatus = data.status.toString()
                }
            }

            override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                Log.e("FETCH ERROR", "Error when Fetching Data", )
            }

        })

        with(binding){
            loginButton.setOnClickListener {
                val status=Helper(this@LoginSuccess).getStatus().toString()
                if (userStatus=="owner"){
                    val intent=Intent(this@LoginSuccess, MainPemilik::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    val intent=Intent(this@LoginSuccess, MainPeternak::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}