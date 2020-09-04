package com.paulsoia.githubauth.data.model

import com.google.gson.annotations.SerializedName

data class SearchApiModel(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val repos: List<RepoApiModel> = listOf()
) {
    companion object {
        fun empty() = SearchApiModel(
            totalCount = 0,
            incompleteResults = false,
            repos = listOf()
        )
    }
}