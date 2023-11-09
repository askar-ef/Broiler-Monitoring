package com.example.broilermonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.broilermonitoring.model.AnakKandangRequest
import com.example.broilermonitoring.model.AnakKandangResponse
import com.example.broilermonitoring.service.AnakKandangInterface
import com.example.broilermonitoring.service.ApiService
import com.example.broilermonitoring.databinding.ActivityRegisterPageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPage : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            loginButton.setOnClickListener {
                val namaLenkap = nameInput.text.toString()
                val username = unameInput.text.toString()
                val email = emailInput.text.toString()
                val password = passwordInput.text.toString()
                val statusUser = statusInput.text.toString()
                val noHp = phoneNumInput.text.toString()
                val RegisterAnakKandang= ApiService().getInstance().create(AnakKandangInterface::class.java)
                RegisterAnakKandang.registerOwner(namaLenkap,username,email,password,statusUser,noHp).enqueue(object :
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
                            Log.e("RegisterPage", "Gagal menerima respons: ${response.code()}")
                            Toast.makeText(this@RegisterPage, "Terjadi kesalahan dalam proses pendaftaran", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<AnakKandangResponse>, t: Throwable) {
                        Toast.makeText(this@RegisterPage, "Terjadi kesalahan jaringan: ${t.message}", Toast.LENGTH_SHORT).show()
                        Log.e("RegisterPage", "Terjadi kesalahan: ${t.message}")



                    }
                })

            }
        }
    }
}