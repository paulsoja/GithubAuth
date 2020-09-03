package com.paulsoia.githubauth.presentation.ui.auth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.paulsoia.githubauth.R
import com.paulsoia.githubauth.data.Const
import com.paulsoia.githubauth.presentation.di.GithubInjector
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : AppCompatActivity(), OAuthWebViewClient.Callback {

    @Inject
    lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        GithubInjector.plusAuthActivityComponent()?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initWebView()
    }

    override fun onDestroy() {
        GithubInjector.clearAuthActivityComponent()
        super.onDestroy()
    }

    private fun initWebView() {
        val oAuthClient = OAuthWebViewClient()
        oAuthClient.callback = this
        val uri = "http://www.osperi.com"
        val clientId = "5cc1d42856d973c46197"
        val url = "${Const.AUTH_URL}client_id=$clientId&redirect_uri=$uri"

        webView.isVerticalScrollBarEnabled = false
        webView.isHorizontalScrollBarEnabled = false
        webView.webViewClient = oAuthClient
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
    }

    override fun onSuccess(code: String) {
        Toast.makeText(this, "ok - $code", Toast.LENGTH_SHORT).show()
    }

    override fun onError() {
        Toast.makeText(this, "bad", Toast.LENGTH_SHORT).show()
    }

}