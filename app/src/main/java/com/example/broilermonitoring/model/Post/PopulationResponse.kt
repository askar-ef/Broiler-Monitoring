package com.example.broilermonitoring.model.Post

import com.google.gson.annotations.SerializedName

data class PopulationResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class Data(

	@field:SerializedName("id_kandang")
	val idKandang: Int? = null,

	@field:SerializedName("populasi")
	val populasi: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("total_kematian")
	val totalKematian: Int? = null
)
