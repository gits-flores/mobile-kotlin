package com.example.course_online.network

import com.example.course_online.data.DataLogin
import com.example.course_online.data.ResponseRegister
import com.example.course_online.data.artikel.DataListArtikel
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
}