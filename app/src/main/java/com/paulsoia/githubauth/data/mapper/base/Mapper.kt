package com.paulsoia.githubauth.data.mapper.base

import java.util.*

abstract class Mapper<From, To> : BaseMapper<From, To>() {
    abstract fun reverse(to: To): From

    fun reverse(tos: List<To>): List<From> =
        ArrayList<From>(tos.size).apply {
            tos.forEach {
                add(reverse(it))
            }
        }
}