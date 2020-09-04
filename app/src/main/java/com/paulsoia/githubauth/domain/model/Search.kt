package com.paulsoia.githubauth.domain.model

data class Search(
    val totalCount: Int,
    val incompleteResults: Boolean,
    val repos: List<Repo> = listOf()
)