package com.example.course_online.data

import com.google.gson.annotations.SerializedName

data class DataLogin(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String
)