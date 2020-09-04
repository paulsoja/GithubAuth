package com.paulsoia.githubauth.presentation.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paulsoia.githubauth.domain.interactors.GetAccessTokenUseCase
import com.paulsoia.githubauth.domain.model.AccessToken
import com.paulsoia.githubauth.presentation.di.scope.PerActivity
import javax.inject.Inject

@PerActivity
class AuthViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase
) : ViewModel() {

    internal val result = MutableLiveData<AccessToken>()
    internal val warningResult = MutableLiveData<String>()

    internal fun getAccessToken(code: String) {
        val params = GetAccessTokenUseCase.Params(code)
        getAccessTokenUseCase(params) {
            it.onSuccess {
                result.value = it
            }.onFailure {
                warningResult.value = it.message
            }
        }
    }

}