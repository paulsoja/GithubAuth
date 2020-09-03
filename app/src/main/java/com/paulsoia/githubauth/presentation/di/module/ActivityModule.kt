package com.paulsoia.githubauth.presentation.di.module

import androidx.appcompat.app.AppCompatActivity
import com.paulsoia.githubauth.presentation.di.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @PerActivity
    fun provideFragmentManager() = activity.supportFragmentManager

}