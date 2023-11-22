package com.example.broilermonitoring.service

import com.example.broilermonitoring.model.Post.DataKandangResponse
import com.example.broilermonitoring.model.Post.DataKematianResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface DataKematianInterface {
    @FormUrlEncoded
    @POST("api/anak-kandang/data-kematian")
    @Headers("Accept: application/json")
    fun postDataKematian(
        @Header("Authorization")Token:String,
        @Field("jam")jam:Int,
        @Field("id_population")idPopulation:Int,
        @Field("kematian")kematian:Int,
    ): Call<DataKematianResponse>
}