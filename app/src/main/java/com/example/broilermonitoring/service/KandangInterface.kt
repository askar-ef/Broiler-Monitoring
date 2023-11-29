package com.example.broilermonitoring.service


import com.example.broilermonitoring.model.ResponseKandang
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface KandangInterface {
    @GET("kandang")
    @Headers("Accept: application/json")
    fun getKandangPerAnak(@Header("Authorization")auth:String): Call<ResponseKandang>

    @GET("owner/kandang")
    @Headers("Accept: application/json")
    fun getKandang(@Header("Authorization")auth: String): Call<ResponseKandang>

    @FormUrlEncoded
    @POST("owner/kandang")
    @Headers("Accept: application/json")
    fun postKandang(
        @Header("Authorization")auth: String,
        @Field("nama_kandang")nama_kandang: String,
        @Field("id_user")id_user: Int,
        @Field("luas_kandang")luas_kandang: Int,
        @Field("alamat_kandang")alamat_kandang: String
        ): Call<ResponseKandang>

}