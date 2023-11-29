package com.example.broilermonitoring.service

import com.example.broilermonitoring.model.Post.DataKandangResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface DataKandangInterface {
    @FormUrlEncoded
    @POST("anak-kandang/data-kandang")
    @Headers("Accept: application/json")
    fun postData(
        @Header("Authorization")Token:String,
        @Field("pakan")pakan:Int,
        @Field("id_kandang")idKandang:Int,
        @Field("minum")minum:Int,
        @Field("bobot")bobot:Int,
    ):Call<DataKandangResponse>

}