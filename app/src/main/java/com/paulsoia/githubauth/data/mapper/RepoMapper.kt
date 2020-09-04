package com.paulsoia.githubauth.data.mapper

import com.paulsoia.githubauth.data.mapper.base.Mapper
import com.paulsoia.githubauth.data.model.RepoApiModel
import com.paulsoia.githubauth.domain.model.Repo
import javax.inject.Inject

class RepoMapper @Inject constructor(
    private val ownerMapper: OwnerMapper
) : Mapper<RepoApiModel, Repo>() {

    override fun reverse(to: Repo) = with(to) {
        RepoApiModel(id, name, fullName, ownerMapper.reverse(owner), isPrivate, description, language)
    }

    override fun map(from: RepoApiModel) = with(from) {
        Repo(id, name, fullName, ownerMapper.map(owner), isPrivate, description, language)
    }

}