package com.example.course_online.data

import com.google.gson.annotations.SerializedName

data class ResponseLogin(
//    @SerializedName("data") val data: DataLogin,
    @SerializedName("token") val token: String
)