package com.example.doctour.domain.usecases

import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class GetFavoriteDoctorsUseCase @Inject constructor(
    private val doctourRepository: DoctourRepository
) {

    operator fun invoke () = doctourRepository.getFavoriteDoctors()
}