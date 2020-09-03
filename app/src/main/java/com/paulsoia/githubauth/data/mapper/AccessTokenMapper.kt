package com.paulsoia.githubauth.data.mapper

import com.paulsoia.githubauth.data.model.AccessTokenApiModel
import com.paulsoia.githubauth.domain.model.AccessToken
import com.paulsoia.githubauth.data.mapper.base.Mapper
import javax.inject.Inject

class AccessTokenMapper @Inject constructor() : Mapper<AccessTokenApiModel, AccessToken>() {

    override fun reverse(to: AccessToken) = with(to) {
        AccessTokenApiModel(accessToken, scope, tokenType, err, errDesc, errUri)
    }

    override fun map(from: AccessTokenApiModel) = with(from) {
        AccessToken(accessToken, scope, tokenType, err, errDesc, errUri)
    }

}