package com.paulsoia.githubauth.presentation.ui.auth

import android.graphics.Bitmap
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class OAuthWebViewClient : WebViewClient() {

    var callback: Callback? = null

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val callbackUrl = "http://www.paulsoja85.com"
        if (request?.url.toString().startsWith(callbackUrl)) {
            val urls = request?.url.toString().split("=")
            callback?.onSuccess(urls[1])
            return true
        }
        return false
    }

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)
        callback?.onError()
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
    }

    interface Callback {
        fun onSuccess(code: String)
        fun onError()
    }

}