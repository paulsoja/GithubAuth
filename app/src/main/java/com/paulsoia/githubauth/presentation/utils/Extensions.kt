package com.paulsoia.githubauth.presentation.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.paulsoia.githubauth.data.net.tools.RetrofitException
import okhttp3.Headers
import retrofit2.Call
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

val Context.networkInfo: NetworkInfo? get() = (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo

internal fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Result<R> =
    requestEx(call, { b, _ -> transform(b) }/*, {}*/, default)

internal fun <T, R> requestEx(call: Call<T>, transform: (T, Headers) -> R, default: T): Result<R> {
    return try {
        val response = call.execute()
        when (response.isSuccessful) {
            true -> Result.success(transform((response.body() ?: default), response.headers()))
            false -> Result.failure(
                RetrofitException.httpError(
                    response.raw()?.request?.url.toString(),
                    response,
                    null
                )
            )
        }
    } catch (exception: Throwable) {
        Result.failure(
            when (exception) {
                is HttpException -> {
                    // We had non-200 http error
                    exception.response().let { response ->
                        RetrofitException.httpError(response?.raw()?.request?.url.toString(), response, null)
                    }
                }
                is SocketTimeoutException -> {
                    RetrofitException.unexpectedError(exception)
                }
                is IOException -> {
                    // A network error happened
                    RetrofitException.networkError(exception)
                }
                else -> {
                    // We don't know what happened. We need to simply convert to an unknown error
                    RetrofitException.unexpectedError(exception)
                }
            }
        )
    }
}