package com.paulsoia.githubauth.data.net

import com.paulsoia.githubauth.data.model.AccessTokenApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AuthApi {

    @GET("/login/oauth/access_token?")
    fun fetchAccessToken(
        @Header("Accept") accept: String? = "application/json",
        @Query("code") code: String,
        @Query("redirect_uri") redirectUri: String,
        @Query("client_secret") clientSecret: String,
        @Query("client_id") clientId: String
    ): Call<AccessTokenApiModel>

}