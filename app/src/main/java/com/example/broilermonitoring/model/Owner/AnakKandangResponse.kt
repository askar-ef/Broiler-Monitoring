package com.example.broilermonitoring.model.Owner

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

data class AnakKandangResponse(

	@field:SerializedName("data")
	val data: List<AnakKandang>? = null
)

data class AnakKandang(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("nama_lengkap")
	val namaLengkap: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("no_telepon")
	val noTelepon: String? = null
)
