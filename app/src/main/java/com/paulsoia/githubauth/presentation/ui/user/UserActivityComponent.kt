package com.paulsoia.githubauth.presentation.ui.user

import com.paulsoia.githubauth.presentation.di.module.ActivityModule
import com.paulsoia.githubauth.presentation.di.scope.PerActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface UserActivityComponent {
    fun inject(userActivity: UserActivity)
}