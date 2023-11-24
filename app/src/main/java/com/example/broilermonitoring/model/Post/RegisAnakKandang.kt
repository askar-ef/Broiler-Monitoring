package com.example.broilermonitoring.model.Post

data class AnakKandangRequest(
    val namaLengkap:String,
    val username: String,
    val email: String,
    val password: String,
    val status:String,
    val noTelpon:String
)
data class AnakKandangResponse(
    val username: String,
    val status: String
)