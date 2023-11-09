package com.example.broilermonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.broilermonitoring.databinding.ActivityLoginPageBinding
import com.example.broilermonitoring.model.AnakKandangResponse
import com.example.broilermonitoring.model.LoginResponse
import com.example.broilermonitoring.service.AnakKandangInterface
import com.example.broilermonitoring.service.ApiService
import com.example.broilermonitoring.service.LoginInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val Bearer= Token(this@LoginPage)

            loginButton.setOnClickListener {
                val username = unameInput.text.toString()
                val password = passwordInput.text.toString()

                val Login= ApiService().getInstance().create(LoginInterface::class.java)
                Login.login(username,password).enqueue(object :
                    Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.isSuccessful) {
                            val registrationResponse = response.body()
                            val token=registrationResponse?.token
//                            Toast.makeText(this@LoginPage, token.toString(), Toast.LENGTH_SHORT).show()
                            Bearer.saveToken(token.toString())
                            val intent=Intent(this@LoginPage,LoginSuccess::class.java)
                            startActivity(intent)
                        } else {
                            Log.e("RegisterPage", "Gagal menerima respons: ${response.code()}")
                            Toast.makeText(this@LoginPage, "Terjadi kesalahan dalam proses pendaftaran", Toast.LENGTH_SHORT).show()
                            val intent=Intent(this@LoginPage,LoginFail::class.java)
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(this@LoginPage, "Terjadi kesalahan jaringan: ${t.message}", Toast.LENGTH_SHORT).show()
                        Log.e("RegisterPage", "Terjadi kesalahan: ${t.message}")



                    }
                })

            }
        }
    }
}