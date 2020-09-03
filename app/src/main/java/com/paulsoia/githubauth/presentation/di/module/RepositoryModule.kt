package com.paulsoia.githubauth.presentation.di.module

import com.paulsoia.githubauth.data.repository.AuthDataRepository
import com.paulsoia.githubauth.data.repository.PreferencesDataRepository
import com.paulsoia.githubauth.data.repository.RepoDataRepository
import com.paulsoia.githubauth.domain.repository.AuthRepository
import com.paulsoia.githubauth.domain.repository.PreferencesRepository
import com.paulsoia.githubauth.domain.repository.RepoRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun preferencesRepository(preferencesRepositoryImpl: PreferencesDataRepository): PreferencesRepository

    @Binds
    @Singleton
    abstract fun authRepository(authDataRepository: AuthDataRepository): AuthRepository

    @Binds
    @Singleton
    abstract fun repoRepository(repoDataRepository: RepoDataRepository): RepoRepository

}