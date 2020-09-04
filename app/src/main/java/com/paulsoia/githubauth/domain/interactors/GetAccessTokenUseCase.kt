package com.paulsoia.githubauth.domain.interactors

import com.paulsoia.githubauth.domain.model.AccessToken
import com.paulsoia.githubauth.domain.repository.AuthRepository
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) : BaseUseCase<GetAccessTokenUseCase.Params, AccessToken>() {

    data class Params(val code: String, val redirectUri: String, val clientSecret: String, val clientId: String)

    override suspend fun run(): Result<AccessToken> {
        if (params == null) throw IllegalArgumentException("Parameter required")
        return try {
            authRepository.fetchAccessToken(params!!.code, params!!.redirectUri, params!!.clientSecret, params!!.clientId)
                .onSuccess {
                    Result.success(it)
                }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}