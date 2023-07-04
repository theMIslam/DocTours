package com.example.doctour.data.repositories

import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.model.UserRegisterDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.data.remote.dtos.auth.SignUpDto
import com.example.doctour.domain.model.UserRegister
import com.example.doctour.domain.repositories.UserRegisterRepository
import com.example.doctour.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRegisterRepositoryImple @Inject constructor(
    private val doctourApi:DoctourApiService
) :UserRegisterRepository,BaseRepository (){

    override fun postRegister(data: UserRegister)=doNetworkRequestWithMapping {
        doctourApi.postRegister(data)
    }

}