package com.paulsoia.githubauth.data.mapper

import com.paulsoia.githubauth.data.mapper.base.Mapper
import com.paulsoia.githubauth.data.model.RepoApiModel
import com.paulsoia.githubauth.data.model.SearchApiModel
import com.paulsoia.githubauth.domain.model.Repo
import com.paulsoia.githubauth.domain.model.Search
import javax.inject.Inject

class SearchMapper @Inject constructor(
    private val repoMapper: RepoMapper,
    private val ownerMapper: OwnerMapper
) : Mapper<SearchApiModel, Search>() {

    override fun reverse(to: Search) = with(to) {
        val itemsRepos = repos.map {
            RepoApiModel(it.id, it.name, it.fullName, ownerMapper.reverse(it.owner), it.isPrivate, it.description, it.language)
        }
        SearchApiModel(totalCount, incompleteResults, itemsRepos)
    }

    override fun map(from: SearchApiModel) = with(from) {
        val itemsRepos = repos.map {
            Repo(it.id, it.name, it.fullName, ownerMapper.map(it.owner), it.isPrivate, it.description, it.language)
        }
        Search(totalCount, incompleteResults, itemsRepos)
    }

}