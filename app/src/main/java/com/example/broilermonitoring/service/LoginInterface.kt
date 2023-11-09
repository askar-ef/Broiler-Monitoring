package com.example.broilermonitoring.service

import com.example.broilermonitoring.Token
import com.example.broilermonitoring.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginInterface {

    @FormUrlEncoded
    @POST("api/login")
    fun login(
        @Field("Username")username:String,
        @Field("Password")password:String
    ): Call<LoginResponse>
}