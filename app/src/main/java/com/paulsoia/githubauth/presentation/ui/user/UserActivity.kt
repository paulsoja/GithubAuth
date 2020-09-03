package com.paulsoia.githubauth.presentation.ui.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paulsoia.githubauth.R
import com.paulsoia.githubauth.domain.PreferencesRepository
import com.paulsoia.githubauth.presentation.di.GithubInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class UserActivity : AppCompatActivity() {

    @Inject
    lateinit var preferencesRepository: PreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        GithubInjector.plusUserActivityComponent(this)?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener {
            preferencesRepository.saveCode("123")
        }
    }

    override fun onDestroy() {
        GithubInjector.clearUserActivityComponent()
        super.onDestroy()
    }

}