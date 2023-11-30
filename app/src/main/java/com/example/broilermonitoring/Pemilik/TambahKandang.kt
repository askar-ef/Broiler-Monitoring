package com.example.broilermonitoring.Pemilik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.broilermonitoring.R
import com.example.broilermonitoring.databinding.PemilikTambahKandangBinding
import com.example.broilermonitoring.model.Helper
import com.example.broilermonitoring.model.Kandang
import com.example.broilermonitoring.model.Owner.AnakKandang
import com.example.broilermonitoring.model.Owner.AnakKandangResponse
import com.example.broilermonitoring.model.ResponseKandang
import com.example.broilermonitoring.service.ApiService
import com.example.broilermonitoring.service.KandangInterface
import com.example.broilermonitoring.service.UserInterface
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Integer.parseInt
import kotlin.properties.Delegates

class TambahKandang : AppCompatActivity() {
    private lateinit var binding: PemilikTambahKandangBinding
    private lateinit var listNamaAnakKandang: ArrayList<String>
    private lateinit var listAnakKandang: ArrayList<AnakKandang>
    private var idAnakKandang by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PemilikTambahKandangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrowBack.setOnClickListener {
            onBackPressed()
        }

        //Ambil data nama tiap anak kandang
        val helper = Helper(this@TambahKandang)
        val token = "Bearer " + helper.getToken().toString()

        val Api = ApiService().getInstance()
        val anakKandangApi = Api.create(UserInterface::class.java)
        val data = anakKandangApi.getAnakKandang(token)

        listNamaAnakKandang = ArrayList<String>()
        listAnakKandang = ArrayList<AnakKandang>()

        data.enqueue(object : Callback<AnakKandangResponse> {
            override fun onResponse(
                call: Call<AnakKandangResponse>,
                response: Response<AnakKandangResponse>
            ) {
                val responseData = response.body()
                val datas = responseData?.data

                if(datas != null) {
                    for(data in datas) {
                        listNamaAnakKandang.add(data?.namaLengkap.toString())
                        listAnakKandang.add(data)
                    }
                }
            }

            override fun onFailure(call: Call<AnakKandangResponse>, t: Throwable) {
                Toast.makeText(this@TambahKandang, "Error Fetching Anak Kandang", Toast.LENGTH_SHORT).show()
            }

        })
        //Adapter Spinner Anak Kandang
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listNamaAnakKandang)
        binding.anakKandangInput.setAdapter(adapter)
        binding.anakKandangInput.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = adapter.getItem(position)
            idAnakKandang = listAnakKandang[position].id!!
        }

        binding.buttonSimpan.setOnClickListener{
            val namaKandang = binding.namaKandangInput.text.toString()
            val alamatKandang = binding.alamatKandangInput.text.toString()
            val luasKandang = parseInt(binding.luasKandangInput.text.toString())

            val kandangApi = Api.create(KandangInterface::class.java)
            kandangApi.postKandang(token, namaKandang,idAnakKandang,luasKandang,alamatKandang)
                .enqueue(object : Callback<Kandang> {
                    override fun onResponse(
                        call: Call<Kandang>,
                        response: Response<Kandang>
                    ) {
                        if(response.isSuccessful) {
                            Toast.makeText(this@TambahKandang, "kandang berhasil dibuat", Toast.LENGTH_LONG).show()
                            finish()
                        }
                    }

                    override fun onFailure(call: Call<Kandang>, t: Throwable) {
                        Log.e("kontol", "onFailure: ${t.message}", )
                    }

                })
        }
    }
}