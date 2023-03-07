package com.example.testwarkopin.data.raw

import com.google.gson.annotations.SerializedName

data class UserRaw(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?
)