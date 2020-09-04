package com.paulsoia.githubauth.domain.repository

import com.paulsoia.githubauth.domain.model.Repo
import com.paulsoia.githubauth.domain.model.Search

interface RepoRepository {

    fun getReposByUser(accessToken: String): Result<List<Repo>>

    fun getReposByName(name: String, accessToken: String): Result<Search>

}