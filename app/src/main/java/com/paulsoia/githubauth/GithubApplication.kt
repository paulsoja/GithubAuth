package com.paulsoia.githubauth

import android.app.Application
import com.paulsoia.githubauth.presentation.di.DaggerAppComponent
import com.paulsoia.githubauth.presentation.di.GithubInjector
import com.paulsoia.githubauth.presentation.di.module.AppModule

class GithubApplication : Application() {

    companion object {
        lateinit var githubApplication: GithubApplication
    }

    override fun onCreate() {
        super.onCreate()
        githubApplication = this
        initAppComponent()
    }

    private fun initAppComponent() {
        GithubInjector.setAppComponent(
            DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        )
    }

}