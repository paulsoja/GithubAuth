package com.paulsoia.githubauth.data.net

import com.paulsoia.githubauth.data.model.AccessTokenApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.Url

interface AuthApi {

    @GET
    fun fetchAccessToken(
        @Url url: String = "https://github.com/login/oauth/access_token?",
        @Header("Accept") accept: String? = "application/json",
        @Query("code") code: String,
        @Query("redirect_uri") redirectUri: String,
        @Query("client_secret") clientSecret: String,
        @Query("client_id") clientId: String
    ): Call<AccessTokenApiModel>

}