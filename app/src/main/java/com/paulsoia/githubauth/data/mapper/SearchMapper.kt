package com.paulsoia.githubauth.data.mapper

import com.paulsoia.githubauth.data.mapper.base.Mapper
import com.paulsoia.githubauth.data.model.SearchApiModel
import com.paulsoia.githubauth.domain.model.Search
import javax.inject.Inject

class SearchMapper @Inject constructor(
    private val repoMapper: RepoMapper
) : Mapper<SearchApiModel, Search>() {

    override fun reverse(to: Search) = with(to) {
        SearchApiModel(totalCount, incompleteResults, repos)
    }

    override fun map(from: SearchApiModel) = with(from) {
        Search(totalCount, incompleteResults, repos)
    }

}