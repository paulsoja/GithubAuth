package com.paulsoia.githubauth.data.model

import com.google.gson.annotations.SerializedName

data class RepoApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("owner") val owner: OwnerApiModel,
    @SerializedName("private") val isPrivate: Boolean,
    @SerializedName("description") val description: String?,
    @SerializedName("language") val language: String?
)