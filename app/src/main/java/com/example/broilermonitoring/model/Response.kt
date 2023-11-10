package com.example.broilermonitoring.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("data")
	val data: List<DataItem>? = null
)

data class DataItem(

	@field:SerializedName("alamat_kandang")
	val alamatKandang: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("id_user")
	val idUser: Int? = null,

	@field:SerializedName("nama_kandang")
	val namaKandang: String? = null,

	@field:SerializedName("luas_kandang")
	val luasKandang: Int? = null
)
