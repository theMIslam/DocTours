package com.example.doctour.di

import androidx.lifecycle.MutableLiveData
import com.example.doctour.data.remote.client.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideTokenErrorListener() = MutableLiveData<String>()

    @Singleton
    @Provides
    fun provideAuthenticatorApiService(
        authenticatorClient: NetworkClient.AuthenticatorClient
    ) = authenticatorClient.provideAuthenticatorApiService()

    @Singleton
    @Provides
    fun provideDoctourApiService(
        networkClient: NetworkClient
    ) = networkClient.provideDoctourApiService()
}