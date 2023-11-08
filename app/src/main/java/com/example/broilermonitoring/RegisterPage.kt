package com.example.broilermonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.broilermonitoring.Model.AnakKandangRequest
import com.example.broilermonitoring.Model.AnakKandangResponse
import com.example.broilermonitoring.Service.AnakKandangInterface
import com.example.broilermonitoring.Service.ApiService
import com.example.broilermonitoring.databinding.ActivityRegisterPageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class RegisterPage : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            loginButton.setOnClickListener {
                val request = AnakKandangRequest(nameInput.text.toString(), unameInput.text.toString(), emailInput.text.toString(), passwordInput.text.toString(), statusInput.text.toString(),phoneNumInput.text.toString().toInt())
                val RegisterAnakKandang= ApiService().getInstance().create(AnakKandangInterface::class.java)
                RegisterAnakKandang.registerOwner(request).enqueue(object :
                    Callback<AnakKandangResponse> {
                    override fun onResponse(call: Call<AnakKandangResponse>, response: Response<AnakKandangResponse>) {
                        if (response.isSuccessful) {
                            val registrationResponse = response.body()
                            val status=registrationResponse?.status
                            Toast.makeText(this@RegisterPage, status.toString(), Toast.LENGTH_SHORT).show()
//                            if (status.equals("Success")){
//                                val inten= Intent(this@RegisterPage,RegisterSuccess::class.java)
//                                startActivity(inten)
//                            }else{
//                                val inten=Intent(this@RegisterPage,RegisterFail::class.java)
//                                startActivity(inten)
//                            }
                        } else {
                            // Handle error response here
                        }
                    }

                    override fun onFailure(call: Call<AnakKandangResponse>, t: Throwable) {
                        // Handle network error here

                    }
                })

            }
        }
    }
}