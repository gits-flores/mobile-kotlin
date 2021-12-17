package com.example.course_online.data

import com.google.gson.annotations.SerializedName

data class DataLogin(
    @SerializedName("token") val token: String,
    @SerializedName("code") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("name") val name: String
)