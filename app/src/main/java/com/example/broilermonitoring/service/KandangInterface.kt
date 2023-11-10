package com.example.broilermonitoring.service


import com.example.broilermonitoring.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface KandangInterface {
    @GET("/kandang/anak-kandang/{id}")
    fun getKandangPerAnak(@Path("id") id: String): Call<Response>
}