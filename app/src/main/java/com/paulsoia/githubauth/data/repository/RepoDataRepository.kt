package com.paulsoia.githubauth.data.repository

import com.paulsoia.githubauth.data.mapper.RepoMapper
import com.paulsoia.githubauth.data.mapper.SearchMapper
import com.paulsoia.githubauth.data.model.SearchApiModel
import com.paulsoia.githubauth.data.net.RepoApi
import com.paulsoia.githubauth.data.net.tools.RetrofitException
import com.paulsoia.githubauth.domain.model.Repo
import com.paulsoia.githubauth.domain.model.Search
import com.paulsoia.githubauth.domain.repository.RepoRepository
import com.paulsoia.githubauth.presentation.utils.request
import java.io.IOException
import javax.inject.Inject

class RepoDataRepository @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val repoApi: RepoApi,
    private val repoMapper: RepoMapper,
    private val searchMapper: SearchMapper
) : RepoRepository {

    override fun getReposByUser(accessToken: String): Result<List<Repo>> {
        return when(networkHandler.isConnected) {
            true -> request(
                call = repoApi.getUserRepos(accessToken),
                transform = { it.map { repoMapper.map(it) } },
                default = listOf()
            )
            false -> Result.failure(RetrofitException.networkError(IOException("No Network Connection")))
        }
    }

    override fun getReposByName(name: String, accessToken: String): Result<Search> {
        return when(networkHandler.isConnected) {
            true -> request(
                call = repoApi.getSearchData(q = name, perPage = 10),
                transform = { searchMapper.map(it) },
                default = SearchApiModel.empty()
            )
            false -> Result.failure(RetrofitException.networkError(IOException("No Network Connection")))
        }
    }

}