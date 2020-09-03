package com.paulsoia.githubauth.data.net

import com.paulsoia.githubauth.data.model.RepoApiModel
import com.paulsoia.githubauth.data.model.SearchApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoApi {

    @GET("search/repositories")
    fun getSearchData(
        @Query("q") q: String,
        @Query("sort") sort: String,
        @Query("order") order: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
    ): Call<SearchApiModel>

    @GET("user/repos")
    fun getUserRepos(
        @Query("access_token") accessToken: String
    ): Call<List<RepoApiModel>>

}