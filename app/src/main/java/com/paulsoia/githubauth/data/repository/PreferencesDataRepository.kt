package com.paulsoia.githubauth.data.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.paulsoia.githubauth.domain.PreferencesRepository
import javax.inject.Inject

class PreferencesDataRepository @Inject constructor(
    private val preferences: SharedPreferences
) : PreferencesRepository {

    companion object {
        private const val CODE = "code"
    }

    override fun saveCode(code: String?) = preferences.edit { putString(CODE, code) }

    override fun getCode() = preferences.getString(CODE, null)

}