package com.paulsoia.githubauth.presentation.ui.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paulsoia.githubauth.domain.interactors.GetReposByNameUseCase
import com.paulsoia.githubauth.domain.interactors.GetReposByUserUseCase
import com.paulsoia.githubauth.domain.model.AccessToken
import com.paulsoia.githubauth.domain.model.Repo
import com.paulsoia.githubauth.presentation.di.scope.PerActivity
import javax.inject.Inject

@PerActivity
class UserViewModel @Inject constructor(
    private val getReposByUserUseCase: GetReposByUserUseCase,
    private val getReposByNameUseCase: GetReposByNameUseCase
) : ViewModel() {

    internal val result = MutableLiveData<List<Repo>>()
    internal val warningResult = MutableLiveData<String>()

    init {
        getRepos()
    }

    private fun getRepos() {
        getReposByUserUseCase {
            it.onSuccess {
                result.value = it
            }.onFailure {
                warningResult.value = it.message
            }
        }
    }

    internal fun searchRepos(name: String) {
        val params = GetReposByNameUseCase.Params(name)
        getReposByNameUseCase(params) {
            it.onSuccess {
                result.value = it.repos
            }.onFailure {
                warningResult.value = it.message
            }
        }
    }

}