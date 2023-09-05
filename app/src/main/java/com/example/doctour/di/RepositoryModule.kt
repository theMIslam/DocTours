package com.example.doctour.di

import com.example.doctour.data.repositories.authRepoImpl.AuthenticationRepositoryImpl
import com.example.doctour.data.repositories.doctourRepoImpl.DoctourRepositoryImpl
import com.example.doctour.domain.repositories.AuthenticationRepository
import com.example.doctour.domain.repositories.DoctourRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindDoctorRepository(doctourRepositoryImpl: DoctourRepositoryImpl)
            : DoctourRepository

    @Binds
    abstract fun bindAuthenticationRepository(authenticationRepositoryImpl: AuthenticationRepositoryImpl)
            : AuthenticationRepository
}