package com.example.broilermonitoring.model

import com.google.gson.annotations.SerializedName

data class RekapDataResponse(

    @field:SerializedName("data")
    val data: Data? = null
)

data class Data(

    @field:SerializedName("id_kandang")
    val idKandang: Int? = null,

    @field:SerializedName("amoniak")
    val amoniak: Int? = null,

    @field:SerializedName("waktu")
    val waktu: String? = null,

    @field:SerializedName("suhu")
    val suhu: Int? = null,

    @field:SerializedName("kelembaban")
    val kelembaban: Int? = null
)
