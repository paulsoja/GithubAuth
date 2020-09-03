package com.paulsoia.githubauth.presentation.di

import com.paulsoia.githubauth.presentation.ui.user.UserActivityComponent
import com.paulsoia.githubauth.presentation.di.module.ActivityModule
import com.paulsoia.githubauth.presentation.ui.auth.AuthActivityComponent
import com.paulsoia.githubauth.presentation.ui.user.UserActivity

object GithubInjector {

    private var appComponent: AppComponent? = null

    fun setAppComponent(appComponent: AppComponent) {
        this.appComponent = appComponent
    }

    private var userActivityComponent: UserActivityComponent? = null
    private var authActivityComponent: AuthActivityComponent? = null

    fun plusUserActivityComponent(activity: UserActivity): UserActivityComponent? {
        return appComponent?.plusUserActivityComponent(ActivityModule(activity)).also {
            userActivityComponent = it
        }
    }

    fun clearUserActivityComponent() {
        userActivityComponent = null
    }

    fun plusAuthActivityComponent(): AuthActivityComponent? {
        return appComponent?.plusAuthActivityComponent().also { authActivityComponent = it }
    }

    fun clearAuthActivityComponent() {
        authActivityComponent = null
    }

}