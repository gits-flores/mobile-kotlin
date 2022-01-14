package com.example.course_online.data.topik

import com.google.gson.annotations.SerializedName

data class ResponseListTopik(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("Modules")
	val modules: List<ModulesItem?>? = null,

	@field:SerializedName("CreatedAt")
	val createdAt: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("rangkuman")
	val rangkuman: String? = null,

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("DeletedAt")
	val deletedAt: Any? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("UpdatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("user")
	val user: User? = null
)

data class Course(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("Modules")
	val modules: Any? = null,

	@field:SerializedName("CreatedAt")
	val createdAt: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("DeletedAt")
	val deletedAt: Any? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("UpdatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("user")
	val user: User? = null
)

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

data class ModulesItem(

	@field:SerializedName("course_id")
	val courseId: Int? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("CreatedAt")
	val createdAt: String? = null,

	@field:SerializedName("ID")
	val iD: Int? = null,

	@field:SerializedName("DeletedAt")
	val deletedAt: Any? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("Course")
	val course: Course? = null,

	@field:SerializedName("UpdatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("content")
	val content: String? = null
)
