package com.example.course_online.network

import com.example.course_online.data.DataLogin
import com.example.course_online.data.ResponseRegister
import com.example.course_online.data.ResponseSaveArticle
import com.example.course_online.data.ResponseUnsaveArticle
import com.example.course_online.data.artikel.DataListArtikel
import com.example.course_online.data.artikel.ResponseDetailArtikel
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
 }