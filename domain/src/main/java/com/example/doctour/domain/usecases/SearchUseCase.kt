package com.example.doctour.domain.usecases

import com.example.doctour.domain.repositories.RemoteDoctorRepository
import javax.inject.Inject

class SearchUseCase  @Inject constructor(
    private var remoteDoctorRepository: RemoteDoctorRepository
){
    operator fun invoke (
        search: String?
    )=remoteDoctorRepository.searchByTitle(search)
}