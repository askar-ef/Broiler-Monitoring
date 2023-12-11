package com.example.broilermonitoring.service

import com.example.broilermonitoring.model.Post.DataKematianResponse
import com.example.broilermonitoring.model.Post.PopulationResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface PopulationInterface {
    @POST("api/population")
    @FormUrlEncoded
    @Headers("Accept: application/json")
    fun PostPopulation(
        @Header("Authorization")Token:String,
        @Field("id_kandang")id_kandang:Int,
        @Field("populasi")populasi:Int,
        @Field("total_kematian")total_kematian:Int=0,
    ): Call<PopulationResponse>
}