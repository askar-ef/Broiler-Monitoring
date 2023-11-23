package com.example.broilermonitoring.model.Post

import com.google.gson.annotations.SerializedName

data class DataKematianResponse(

	@field:SerializedName("data")
	val data: DataKematian? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class DataKematian(

	@field:SerializedName("kematian")
	val kematian: String? = null,

	@field:SerializedName("id_population")
	val idPopulation: String? = null,

	@field:SerializedName("jam")
	val jam: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
