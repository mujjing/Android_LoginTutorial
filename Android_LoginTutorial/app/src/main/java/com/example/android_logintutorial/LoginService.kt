package com.example.android_logintutorial

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {

    @FormUrlEncoded
    @POST("/api/login")
    fun requestLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Login>

}