package com.example.doctour.domain.usecases

import com.example.doctour.domain.repositories.RemoteDoctorRepository
import javax.inject.Inject


class GetCategoryServiceUseCase @Inject constructor(
    private val remoteDoctorRepository: RemoteDoctorRepository
) {
    operator fun invoke(
        name:String?,
        price:String?,
        search:String?
    )=remoteDoctorRepository.getCategoryServicesOfDoctors( name, price, search)

}