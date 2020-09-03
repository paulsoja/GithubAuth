package com.paulsoia.githubauth.domain.repository

import com.paulsoia.githubauth.domain.model.AccessToken

interface AuthRepository {

    fun fetchAccessToken(
        code: String,
        redirectUri: String,
        clientSecret: String,
        clientId: String
    ): Result<AccessToken>

}