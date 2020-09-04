package com.paulsoia.githubauth.domain.interactors

import com.paulsoia.githubauth.domain.model.Search
import com.paulsoia.githubauth.domain.repository.PreferencesRepository
import com.paulsoia.githubauth.domain.repository.RepoRepository
import javax.inject.Inject

class GetReposByNameUseCase @Inject constructor(
    private val repoRepository: RepoRepository,
    private val preferencesRepository: PreferencesRepository
) : BaseUseCase<GetReposByNameUseCase.Params, Search>() {

    data class Params(val name: String)

    override suspend fun run(): Result<Search> {
        if (params == null) throw IllegalArgumentException("Parameter required")
        return try {
            preferencesRepository.getAccessToken()?.let {
                repoRepository.getReposByName(params!!.name, it).onSuccess {
                    Result.success(it)
                }
            } ?: Result.failure(Throwable("No access token"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}