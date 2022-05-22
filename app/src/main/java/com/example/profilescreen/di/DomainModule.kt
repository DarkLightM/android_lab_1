package com.example.profilescreen.di

import com.example.profilescreen.domain.api.ApiProvider
import com.example.profilescreen.domain.api.ApiService
import com.example.profilescreen.domain.api.RetrofitClient
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideRetrofitClient(): RetrofitClient =
        RetrofitClient()

    @Provides
    fun provideApiProvider(client: RetrofitClient): ApiProvider =
        ApiProvider(client)

    @Provides
    fun provideApi(apiProvider: ApiProvider): ApiService =
        apiProvider.getApi()
}