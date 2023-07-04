package com.example.doctour.di

import com.example.doctour.data.repositories.DoctourRepositoryImpl
import com.example.doctour.data.repositories.UserRegisterRepositoryImple
import com.example.doctour.domain.repositories.RemoteDoctorRepository
import com.example.doctour.domain.repositories.UserRegisterRepository
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

    @Binds
    abstract  fun bindUserRegisterRepository(userRegisterRepositoryImple: UserRegisterRepositoryImple)
    :UserRegisterRepository
}