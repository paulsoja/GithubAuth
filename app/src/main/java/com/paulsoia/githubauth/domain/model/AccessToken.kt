package com.paulsoia.githubauth.domain.model

data class AccessToken(
    val accessToken: String?,
    val scope: String?,
    val tokenType: String?,
    val err: String?,
    val errDesc: String?,
    val errUri: String?
)