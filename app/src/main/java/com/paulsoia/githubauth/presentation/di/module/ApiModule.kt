package com.paulsoia.githubauth.presentation.di.module

import com.google.gson.GsonBuilder
import com.paulsoia.githubauth.data.Const
import com.paulsoia.githubauth.data.net.RepoApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(gsonBuilder: GsonBuilder, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
            .baseUrl(Const.HOST_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideGoodsApi(retrofit: Retrofit): RepoApi {
        return retrofit.create(RepoApi::class.java)
    }

}