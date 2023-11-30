package com.example.broilermonitoring.service

import com.example.broilermonitoring.model.Post.AnakKandangResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RegisterInterface {

    //    @Headers("Content-type:aplication-json")
    @FormUrlEncoded
    @POST("register-anak-kandang")
    fun registerAnakKandang(
        @Field("nama_lengkap") nama_lengkap:String,
        @Field("username") username:String,
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("no_telepon") no_telepon:String,
    ): Call<AnakKandangResponse>

    @FormUrlEncoded
    @POST("register-owner")
    fun registerOwner(
        @Field("nama_lengkap") nama_lengkap:String,
        @Field("username") username:String,
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("no_telepon") no_telepon:String,
    ): Call<AnakKandangResponse>

}