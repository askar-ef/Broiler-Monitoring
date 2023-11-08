package com.example.broilermonitoring.Model

data class AnakKandangRequest(
    val nama_lengkap:String,
    val username: String,
    val email: String,
    val password: String,
    val status:String,
    val no_telpon:Int
)
data class AnakKandangResponse(
    val username: String,
    val status: String
)