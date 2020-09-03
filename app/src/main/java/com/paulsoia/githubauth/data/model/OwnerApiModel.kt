package com.paulsoia.githubauth.data.model

import com.google.gson.annotations.SerializedName

class OwnerApiModel(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String
)