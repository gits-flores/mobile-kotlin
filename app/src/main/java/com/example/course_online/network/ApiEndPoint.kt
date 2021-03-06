package com.example.course_online.network

import com.example.course_online.data.*
import com.example.course_online.data.artikel.DataListArtikel
import com.example.course_online.data.artikel.ResponseDetailArtikel
import com.example.course_online.data.topik.ResponseListTopik
import retrofit2.Call
import retrofit2.http.*

interface ApiEndPoint {

    @FormUrlEncoded
    @POST("login")
    fun Login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<DataLogin>

    @FormUrlEncoded
    @POST("register")
    fun Register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<ResponseRegister>


    @GET("articles")
    fun getListArtikel(
        @Header("Authorization") token: String
    ): Call<List<DataListArtikel>>

    @GET("articles/{id}")
    fun getDetailArtikel(
        @Header("Authorization") token: String,
        @Path("id") artikel_id: Int
    ): Call<ResponseDetailArtikel>

    @FormUrlEncoded
    @POST("save-article-user")
    fun saveArticle(
        @Header("Authorization") token: String,
        @Field("user_id") user_id: String,
        @Field("article_id") article_id: Int?
    ): Call<ResponseSaveArticle>

    @GET("delete-article-user/{user_id}/{article_id}")
    fun unSaveArticle(
        @Header("Authorization") token: String,
        @Path("user_id") user_id: String,
        @Path("article_id") article_id: Int
    ): Call<ResponseUnsaveArticle>

    @GET("save-article-user/{user_id}")
    fun getSaveArticles(
        @Header("Authorization") token: String,
        @Path("user_id") user_id: String,
    ): Call<List<DataSaveArticle>>

    @GET("courses")
    fun getListCourse(
        @Header("Authorization") token: String,
    ): Call<List<ResponseListTopik>>

    @GET("courses/{id}")
    fun getListTopik(
        @Header("Authorization") token: String,
        @Path("id") id_Course: Int
    ): Call<ResponseListTopik>

    @GET("cek-article-user/{user_id}/{article_id}")
    fun cekSaveArticle(
        @Header("Authorization") token: String,
        @Path("user_id") user_id: String,
        @Path("article_id") article_id: Int?
    ): Call<List<ResponseCekArticle>>
}