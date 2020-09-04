package com.paulsoia.githubauth.presentation.ui.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paulsoia.githubauth.domain.interactors.GetReposByUserUseCase
import com.paulsoia.githubauth.domain.model.AccessToken
import com.paulsoia.githubauth.domain.model.Repo
import com.paulsoia.githubauth.presentation.di.scope.PerActivity
import javax.inject.Inject

@PerActivity
class UserViewModel @Inject constructor(
    private val getReposByUserUseCase: GetReposByUserUseCase
) : ViewModel() {

    internal val result = MutableLiveData<List<Repo>>()
    internal val warningResult = MutableLiveData<String>()

    init {
        getRepos()
    }

    internal fun getRepos() {
        getReposByUserUseCase {
            it.onSuccess {
                result.value = it
            }.onFailure {
                warningResult.value = it.message
            }
        }
    }

}