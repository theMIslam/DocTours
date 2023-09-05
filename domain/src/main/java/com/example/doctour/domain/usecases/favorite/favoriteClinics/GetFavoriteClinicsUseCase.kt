package com.example.doctour.domain.usecases.favorite.favoriteClinics

import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class GetFavoriteClinicsUseCase @Inject constructor(
    private val doctourRepository: DoctourRepository
) {

    operator fun invoke () = doctourRepository.getFavoriteClinics()
}