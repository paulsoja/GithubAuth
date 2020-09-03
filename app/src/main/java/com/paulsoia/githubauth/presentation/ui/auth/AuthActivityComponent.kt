package com.paulsoia.githubauth.presentation.ui.auth

import com.paulsoia.githubauth.presentation.di.scope.PerActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent
interface AuthActivityComponent {
    fun inject(authActivity: AuthActivity)
}