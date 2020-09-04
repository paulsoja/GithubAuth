package com.paulsoia.githubauth.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.paulsoia.githubauth.R
import com.paulsoia.githubauth.data.Const
import com.paulsoia.githubauth.domain.repository.PreferencesRepository
import com.paulsoia.githubauth.presentation.di.GithubInjector
import com.paulsoia.githubauth.presentation.ui.user.UserActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : AppCompatActivity(), OAuthWebViewClient.Callback {

    @Inject
    lateinit var viewModel: AuthViewModel
    @Inject
    lateinit var preferencesRepository: PreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        GithubInjector.plusAuthActivityComponent()?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initWebView()
        accessTokenResult()
        warning()
    }

    override fun onDestroy() {
        GithubInjector.clearAuthActivityComponent()
        super.onDestroy()
    }

    private fun initWebView() {
        val oAuthClient = OAuthWebViewClient()
        oAuthClient.callback = this
        val uri = "http://www.paulsoja85.com"
        val clientId = "2a863785de5c718913d0"
        val url = "${Const.AUTH_URL}client_id=$clientId&redirect_uri=$uri"

        webView.isVerticalScrollBarEnabled = false
        webView.isHorizontalScrollBarEnabled = false
        webView.webViewClient = oAuthClient
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
    }

    override fun onSuccess(code: String) {
        Log.d("Code_ok", code)
        viewModel.getAccessToken(
            code = code,
            redirectUri = "http://www.paulsoja85.com",
            clientId = "2a863785de5c718913d0",
            clientSecret = "eb2c44c3774c7eb8696675a331d378110a782d1f"
        )
    }

    override fun onError() {
        Toast.makeText(this, "bad", Toast.LENGTH_SHORT).show()
    }

    private fun accessTokenResult() {
        viewModel.result.observe(this, {
            preferencesRepository.saveAccessToken("${it.accessToken}")
            startActivity(Intent(this, UserActivity::class.java))
            finishAffinity()
        })
    }

    private fun warning() {
        viewModel.warningResult.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            Log.d("warning", it)
        })
    }

}