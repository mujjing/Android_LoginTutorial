package com.example.android_logintutorial

import com.google.gson.annotations.SerializedName

data class Login (
    val user: User,
    val token: String
)

data class User (
    val id: Long,
    val name: String,
    val email: String,

    @SerializedName("email_verified_at")
    val emailVerifiedAt: Any? = null,

    @SerializedName("device_token")
    val deviceToken: Any? = null,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("updated_at")
    val updatedAt: Any? = null
)