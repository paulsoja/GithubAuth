package com.paulsoia.githubauth.domain.repository

interface PreferencesRepository {

    fun saveAccessToken(accessToken: String?)
    fun getAccessToken(): String?

}