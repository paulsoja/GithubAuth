package com.paulsoia.githubauth.data.model

import com.google.gson.annotations.SerializedName

data class AccessTokenApiModel(
    @SerializedName("access_token") val accessToken: String?,
    @SerializedName("scope") val scope: String?,
    @SerializedName("token_type") val tokenType: String?,
    @SerializedName("error") val err: String? = null,
    @SerializedName("error_description") val errDesc: String? = null,
    @SerializedName("error_uri") val errUri: String? = null
) {
    companion object {
        fun empty() = AccessTokenApiModel(
            accessToken = null,
            scope = null,
            tokenType = null
        )
    }
}