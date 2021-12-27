package com.example.course_online.data.artikel

import com.google.gson.annotations.SerializedName


//data class DataListArtikel(
//
//	@field:SerializedName("DataListArtikel")
//	val dataListArtikel: List<DataListArtikelItem?>? = null
//)

data class User(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("role")
	val role: Int? = null,

	@field:SerializedName("CreatedAt")
	val createdAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("DeletedAt")
	val deletedAt: Any? = null,

	@field:SerializedName("UpdatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class DataListArtikel(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("CreatedAt")
	val createdAt: String? = null,

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("DeletedAt")
	val deletedAt: Any? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("UpdatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("content")
	val content: String? = null
)
