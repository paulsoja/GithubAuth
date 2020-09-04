package com.paulsoia.githubauth.data.mapper.base

import java.util.*

abstract class BaseMapper<From, To> {
    abstract fun map(from: From): To

    fun map(froms: List<From>): List<To> =
        ArrayList<To>(froms.size).apply {
            froms.forEach {
                add(map(it))
            }
        }
}