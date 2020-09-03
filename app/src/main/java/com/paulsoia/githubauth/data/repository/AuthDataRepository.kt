package com.paulsoia.githubauth.data.repository

import com.paulsoia.githubauth.data.mapper.AccessTokenMapper
import com.paulsoia.githubauth.data.model.AccessTokenApiModel
import com.paulsoia.githubauth.data.net.AuthApi
import com.paulsoia.githubauth.data.net.tools.RetrofitException
import com.paulsoia.githubauth.domain.model.AccessToken
import com.paulsoia.githubauth.domain.repository.AuthRepository
import com.paulsoia.githubauth.presentation.utils.request
import java.io.IOException
import javax.inject.Inject

class AuthDataRepository @Inject constructor(
    private val authApi: AuthApi,
    private val networkHandler: NetworkHandler,
    private val accessTokenMapper: AccessTokenMapper
) : AuthRepository {

    override fun fetchAccessToken(
        code: String,
        redirectUri: String,
        clientSecret: String,
        clientId: String
    ): Result<AccessToken> {
        return when (networkHandler.isConnected) {
            true -> request(
                call = authApi.fetchAccessToken(
                    code = code,
                    redirectUri = redirectUri,
                    clientSecret = clientSecret,
                    clientId = clientId
                ),
                transform = { accessTokenMapper.map(it) },
                default = AccessTokenApiModel.empty()
            )
            false -> Result.failure(RetrofitException.networkError(IOException("No Network Connection")))
        }
    }

}