package com.example.broilermonitoring.service


import com.example.broilermonitoring.model.ResponseKandang
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface KandangInterface {
    @GET("api/kandang")
    @Headers("Accept: application/json")
    fun getKandangPerAnak(@Header("Authorization")auth:String): Call<ResponseKandang>
}