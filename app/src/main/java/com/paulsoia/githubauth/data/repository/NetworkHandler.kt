package com.paulsoia.githubauth.data.repository

import android.app.Application
import com.paulsoia.githubauth.presentation.utils.networkInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHandler @Inject constructor(private val application: Application) {
    val isConnected get() = application.networkInfo?.isConnectedOrConnecting == true
}