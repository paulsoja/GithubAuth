package com.paulsoia.githubauth.presentation.di

import com.paulsoia.githubauth.presentation.ui.user.UserActivityComponent
import com.paulsoia.githubauth.presentation.di.module.ActivityModule
import com.paulsoia.githubauth.presentation.di.module.ApiModule
import com.paulsoia.githubauth.presentation.di.module.AppModule
import com.paulsoia.githubauth.presentation.di.module.RepositoryModule
import com.paulsoia.githubauth.presentation.ui.auth.AuthActivityComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        RepositoryModule::class
    ]
)

interface AppComponent {
    fun plusUserActivityComponent(activityModule: ActivityModule): UserActivityComponent
    fun plusAuthActivityComponent(): AuthActivityComponent
}