package com.example.broilermonitoring.Service

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiService {
    companion object{
        const val BASE_URL="http://10.0.2.2:8000/"
    }
    private var retrofit: Retrofit?=null


    var gson = GsonBuilder()
        .setLenient()
        .create()

    fun getInstance():Retrofit{
        if(retrofit==null){
            retrofit=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofit!!
    }
//
}