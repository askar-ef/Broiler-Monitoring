package com.example.broilermonitoring.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.broilermonitoring.model.Post.AnakKandangResponse
import com.example.broilermonitoring.service.ApiService
import com.example.broilermonitoring.databinding.ActivityRegisterPageBinding
import com.example.broilermonitoring.model.Helper
import com.example.broilermonitoring.service.RegisterInterface
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
                val namaLengkap = nameInput.text.toString()
                val username = unameInput.text.toString()
                val email = emailInput.text.toString()
                val password = passwordInput.text.toString()
                val noHp = phoneNumInput.text.toString()
                val Register = ApiService().getInstance().create(RegisterInterface::class.java)

                val helper = Helper(this@RegisterPage)
                val status = helper.getStatus()

                Log.d("STATUS", "onCreate() returned: $status")

                if(status == "owner") {
                    Register.registerOwner(namaLengkap, username, email, password, noHp).enqueue(object :
                        Callback<AnakKandangResponse> {
                        override fun onResponse(
                            call: Call<AnakKandangResponse>,
                            response: Response<AnakKandangResponse>
                        ) {
                            if (response.isSuccessful) {
                                val registrationResponse = response.body()
                                val statusResponse = registrationResponse?.status
                                if (statusResponse.equals("Success")){
                                    val inten= Intent(this@RegisterPage, RegisterSuccess::class.java)
                                    startActivity(inten)
                                    finish()
                                }else{
                                    val inten=Intent(this@RegisterPage, RegisterFail::class.java)
                                    startActivity(inten)
                                    finish()
                                }
                            } else {
                                Log.e("RegisterPage", "Gagal menerima respons: ${response.code()}")
                                Toast.makeText(this@RegisterPage, "Terjadi kesalahan dalam proses pendaftaran", Toast.LENGTH_SHORT).show()
                                val inten=Intent(this@RegisterPage, RegisterFail::class.java)
                                startActivity(inten)
                                finish()
                            }
                        }

                        override fun onFailure(call: Call<AnakKandangResponse>, t: Throwable) {
                            Toast.makeText(this@RegisterPage, "Terjadi Kesalahan: ${t.message}", Toast.LENGTH_SHORT).show()
                            Log.e("RegisterPage", "Terjadi kesalahan: ${t.message}")
                            val inten=Intent(this@RegisterPage, RegisterFail::class.java)
                            startActivity(inten)
                            finish()
                        }

                    })
                }else if(status == "anak kandang"){
                    Register.registerAnakKandang(namaLengkap, username, email, password, noHp).enqueue(object :
                        Callback<AnakKandangResponse> {
                        override fun onResponse(call: Call<AnakKandangResponse>, response: Response<AnakKandangResponse>) {
                            if (response.isSuccessful) {
                                val registrationResponse = response.body()
                                val statusResponse=registrationResponse?.status
                                //                            Toast.makeText(this@RegisterPage, status.toString(), Toast.LENGTH_SHORT).show()
                                if (statusResponse.equals("Success")){
                                    val inten= Intent(this@RegisterPage, RegisterSuccess::class.java)
                                    startActivity(inten)
                                    finish()
                                }else{
                                    val inten=Intent(this@RegisterPage, RegisterFail::class.java)
                                    startActivity(inten)
                                    finish()
                                }
                            } else {
                                Log.e("RegisterPage", "Gagal menerima respons: ${response.code()}")
                                Toast.makeText(this@RegisterPage, "Terjadi kesalahan dalam proses pendaftaran", Toast.LENGTH_SHORT).show()
                                val inten=Intent(this@RegisterPage, RegisterFail::class.java)
                                startActivity(inten)
                                finish()
                            }
                        }

                        override fun onFailure(call: Call<AnakKandangResponse>, t: Throwable) {
                            Toast.makeText(this@RegisterPage, "Terjadi Kesalahan: ${t.message}", Toast.LENGTH_SHORT).show()
                            Log.e("RegisterPage", "Terjadi kesalahan: ${t.message}")
                            val inten=Intent(this@RegisterPage, RegisterFail::class.java)
                            startActivity(inten)
                            finish()
                        }
                    })
                }
            }
        }
    }
}