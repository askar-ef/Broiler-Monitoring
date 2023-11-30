package com.example.broilermonitoring.Pemilik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.broilermonitoring.R
import com.example.broilermonitoring.databinding.TambahKandangBinding
import com.example.broilermonitoring.model.Helper
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
    private lateinit var binding: TambahKandangBinding
    private lateinit var listNamaAnakKandang: ArrayList<String>
    private lateinit var listAnakKandang: ArrayList<AnakKandang>
    private var idAnakKandang by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TambahKandangBinding.inflate(layoutInflater)
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
        binding.anakKandang.setAdapter(adapter)
        binding.anakKandang.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = adapter.getItem(position)
            idAnakKandang = listAnakKandang[position].id!!
        }

        binding.button.setOnClickListener{
            val namaKandang = binding.namaKandang.text.toString()
            val alamatKandang = binding.alamatKandang.text.toString()
            val luasKandang = parseInt(binding.luasKandang.text.toString())

            val kandangApi = Api.create(KandangInterface::class.java)
            kandangApi.postKandang(token, namaKandang,idAnakKandang,luasKandang,alamatKandang)
                .enqueue(object : Callback<ResponseKandang> {
                    override fun onResponse(
                        call: Call<ResponseKandang>,
                        response: Response<ResponseKandang>
                    ) {
                        val responseData = response.body()
                        val responseStatus = responseData?.data

                        if(responseStatus != null){
                            finish()
                        }
                    }

                    override fun onFailure(call: Call<ResponseKandang>, t: Throwable) {
                        finish()
                    }

                })
        }
    }
}