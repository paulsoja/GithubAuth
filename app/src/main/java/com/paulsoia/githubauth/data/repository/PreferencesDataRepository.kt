package com.paulsoia.githubauth.data.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.paulsoia.githubauth.domain.repository.PreferencesRepository
import javax.inject.Inject

class PreferencesDataRepository @Inject constructor(
    private val preferences: SharedPreferences
) : PreferencesRepository {

    companion object {
        private const val CODE = "code"
    }

    override fun saveAccessToken(accessToken: String?) = preferences.edit { putString(CODE, accessToken) }

    override fun getAccessToken() = preferences.getString(CODE, null)

}