package com.paulsoia.githubauth.data.mapper

import com.paulsoia.githubauth.data.mapper.base.Mapper
import com.paulsoia.githubauth.data.model.OwnerApiModel
import com.paulsoia.githubauth.domain.model.Owner
import javax.inject.Inject

class OwnerMapper @Inject constructor() : Mapper<OwnerApiModel, Owner>() {

    override fun reverse(to: Owner) = with(to) {
        OwnerApiModel(login, id, avatarUrl)
    }

    override fun map(from: OwnerApiModel) = with(from) {
        Owner(login, id, avatarUrl)
    }

}