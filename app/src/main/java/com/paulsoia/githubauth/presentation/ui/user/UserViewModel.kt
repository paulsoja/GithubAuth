package com.paulsoia.githubauth.presentation.ui.user

import androidx.lifecycle.ViewModel
import com.paulsoia.githubauth.presentation.di.scope.PerActivity
import javax.inject.Inject

@PerActivity
class UserViewModel @Inject constructor(

) : ViewModel() {

    init {
        getRepos()
    }

    internal fun getRepos() {

    }

}