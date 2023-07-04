package com.example.doctour.data.repositories

import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.model.UserRegisterDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.UserRegister
import com.example.doctour.domain.repositories.UserRegisterRepository
import javax.inject.Inject

class UserRegisterRepositoryImple @Inject constructor(
    private val doctourApi: DoctourApiService
) : UserRegisterRepository, BaseRepository() {

    override fun postRegister(
        phone_number: String?,
        fullname: String?,
        gender: String?,
        birthday: String?,
        password: String?
    ) = makeNetworkRequest {
        doctourApi.postRegister(
            UserRegisterDt(
                phone_number, fullname, gender, birthday, password
            )
        ).mapToDomain()
    }

}