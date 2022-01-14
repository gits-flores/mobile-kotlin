package com.example.course_online.data

data class ResponseCekArticle(
    val articleId: Int? = null,
    val userId: Int? = null,
    val createdAt: String? = null,
    val iD: Int? = null,
    val deletedAt: Any? = null,
    val updatedAt: String? = null,
    val user: User? = null,
    val article: Article? = null
)

//data class User(
//    val password: String? = null,
//    val role: Int? = null,
//    val createdAt: String? = null,
//    val name: String? = null,
//    val iD: Int? = null,
//    val id: Int? = null,
//    val deletedAt: Any? = null,
//    val updatedAt: String? = null,
//    val email: String? = null
//)
//
//data class Article(
//    val thumbnail: String? = null,
//    val userId: Int? = null,
//    val createdAt: String? = null,
//    val iD: Int? = null,
//    val deletedAt: Any? = null,
//    val title: String? = null,
//    val updatedAt: String? = null,
//    val user: User? = null,
//    val content: String? = null
//)

