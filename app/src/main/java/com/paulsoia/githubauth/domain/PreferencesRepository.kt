package com.paulsoia.githubauth.domain

interface PreferencesRepository {

    fun saveCode(code: String?)
    fun getCode(): String?

}