package com.example.broilermonitoring.Service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    companion object{
        const val BASE_URL="http://127.0.0.1:8000/"
    }
    private var retrofit: Retrofit?=null

    fun getInstance():Retrofit{
        if(retrofit==null){
            retrofit=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
//
}