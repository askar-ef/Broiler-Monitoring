package com.example.broilermonitoring.model.Post

import com.google.gson.annotations.SerializedName

data class DataKandangResponse(

	@field:SerializedName("data")
	val data: DataKandang? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class DataKandang(

	@field:SerializedName("pakan")
	val pakan: Int? = null,

	@field:SerializedName("id_kandang")
	val idKandang: Int? = null,

	@field:SerializedName("bobot")
	val bobot: Int? = null,

	@field:SerializedName("minum")
	val minum: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
