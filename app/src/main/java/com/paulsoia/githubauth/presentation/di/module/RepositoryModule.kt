package com.paulsoia.githubauth.presentation.di.module

import com.paulsoia.githubauth.data.repository.PreferencesDataRepository
import com.paulsoia.githubauth.domain.PreferencesRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun preferencesRepository(preferencesRepositoryImpl: PreferencesDataRepository): PreferencesRepository

}