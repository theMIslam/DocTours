package com.example.doctour.di

import com.example.doctour.data.repositories.DoctourRepositoryImpl
import com.example.doctour.domain.repositories.RemoteDoctorRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRemoteDoctorRepository(doctourRepositoryImpl: DoctourRepositoryImpl)
    :RemoteDoctorRepository
}