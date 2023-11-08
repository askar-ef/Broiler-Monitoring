package com.example.broilermonitoring.Service

import com.example.broilermonitoring.Model.AnakKandangRequest
import com.example.broilermonitoring.Model.AnakKandangResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AnakKandangInterface {
    @POST("api/register-anak-kandang")
    fun registerOwner(@Body request: AnakKandangRequest): Call<AnakKandangResponse>
}
