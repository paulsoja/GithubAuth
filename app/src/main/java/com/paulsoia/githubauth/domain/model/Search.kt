package com.paulsoia.githubauth.domain.model

import com.paulsoia.githubauth.data.model.RepoApiModel

data class Search(
    val totalCount: Int,
    val incompleteResults: Boolean,
    val repos: List<RepoApiModel> = listOf()
)