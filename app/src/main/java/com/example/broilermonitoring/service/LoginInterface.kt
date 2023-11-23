package com.example.broilermonitoring.service

import com.example.broilermonitoring.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginInterface {

    @FormUrlEncoded
    @POST("api/login")
    fun login(
        @Field("username")username:String,
        @Field("password")password:String
    ): Call<LoginResponse>
}