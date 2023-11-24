package com.example.broilermonitoring.service

import com.example.broilermonitoring.model.RekapDataResponse
import com.example.broilermonitoring.model.ResponseKandang
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface RekapDataHarian {
    @GET("api/rekap-data-harian/{id_kandang}")
    @Headers("Accept: application/json")
    fun getRekap(@Header("Authorization")auth:String,@Path("id_kandang")id_kandang:Int): Call<RekapDataResponse>
}