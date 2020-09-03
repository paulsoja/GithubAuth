package com.paulsoia.githubauth.domain.model

data class Repo(
    val id: Int,
    val name: String,
    val fullName: String,
    val owner: Owner,
    val isPrivate: Boolean,
    val description: String,
    val language: String
)