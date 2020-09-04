package com.paulsoia.githubauth.domain.interactors

import com.paulsoia.githubauth.data.Const
import com.paulsoia.githubauth.domain.model.AccessToken
import com.paulsoia.githubauth.domain.repository.AuthRepository
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) : BaseUseCase<GetAccessTokenUseCase.Params, AccessToken>() {

    data class Params(val code: String)

    override suspend fun run(): Result<AccessToken> {
        if (params == null) throw IllegalArgumentException("Parameter required")
        return try {
            authRepository.fetchAccessToken(params!!.code, Const.URL_CALLBACK, Const.CLIENT_SECRET, Const.CLIENT_ID)
                .onSuccess {
                    Result.success(it)
                }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}