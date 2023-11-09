package com.example.broilermonitoring.service

import com.example.broilermonitoring.model.AnakKandangRequest
import com.example.broilermonitoring.model.AnakKandangResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface AnakKandangInterface {

//    @Headers("Content-type:aplication-json")
    @FormUrlEncoded
    @POST("api/register-anak-kandang")
    fun registerOwner(
        @Field("nama_lengkap") nama_lengkap:String,
        @Field("username") username:String,
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("status") status:String,
        @Field("no_telepon") no_telepon:String,
    ): Call<AnakKandangResponse>
    //
}
