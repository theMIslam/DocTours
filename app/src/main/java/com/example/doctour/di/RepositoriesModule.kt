package com.example.doctour.di

import com.example.doctour.data.repositories.DoctourRepositoryImpl
import com.example.doctour.domain.repositories.DoctourRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindFooRepository(
        repositoryImpl: DoctourRepositoryImpl
    ): DoctourRepository
}