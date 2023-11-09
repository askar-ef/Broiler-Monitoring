package com.example.broilermonitoring.service

import com.example.broilermonitoring.model.AnakKandangRequest
import com.example.broilermonitoring.model.AnakKandangResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface AnakKandangInterface {

//    @Headers("Content-type:aplication-json")
    @FormUrlEncoded
    @POST("api/register-anak-kandang")
    fun registerOwner(@Body request: AnakKandangRequest): Call<AnakKandangResponse>
    //
}
