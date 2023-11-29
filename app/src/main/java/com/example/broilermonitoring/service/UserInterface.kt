package com.example.broilermonitoring.service

import com.example.broilermonitoring.model.Owner.AnakKandangResponse
import com.example.broilermonitoring.model.ProfileResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface UserInterface {
    @GET("profile")
    @Headers("Accept: application/json")
    fun profile(@Header("Authorization")auth: String): Call<ProfileResponse>

    @GET("owner/user")
    @Headers("Accept: application/json")
    fun getAnakKandang(@Header("Authorization")auth: String): Call<AnakKandangResponse>
}