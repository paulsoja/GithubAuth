package com.paulsoia.githubauth.domain.interactors

import android.util.Log
import com.paulsoia.githubauth.domain.model.Repo
import com.paulsoia.githubauth.domain.repository.PreferencesRepository
import com.paulsoia.githubauth.domain.repository.RepoRepository
import java.lang.Exception
import javax.inject.Inject

class GetReposByUserUseCase @Inject constructor(
    private val repoRepository: RepoRepository,
    private val preferencesRepository: PreferencesRepository
) : BaseUseCase<BaseUseCase.None, List<Repo>>() {

    override suspend fun run(): Result<List<Repo>> {
        return try {
            preferencesRepository.getAccessToken()?.let {
                repoRepository.getReposByUser(it).onSuccess {
                    Result.success(it)
                }.onFailure {
                    Log.d("GetRepos failure: ", it.message!!)
                }
            } ?:
            Result.failure(Throwable("No access token"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}