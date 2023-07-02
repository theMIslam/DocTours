package com.example.doctour.data.repositories

import android.util.Log
import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.data.remote.dto.changepassword.changePasswordDto
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val doctourApiService: DoctourApiService,
) : BaseRepository() {

//    fun getUserProfile(id: Int = userPreferences.userID.toString().toInt()) = makeNetworkRequest {
//        doctourApiService.getUserProfile(id)
//    }
//
//    fun deleteAccount() = makeNetworkRequest {
//        doctourApiService.deleteAccount(
//            userPreferences.userID.toString().toInt()
//        )
//    }
//
//    fun getFavoriteTours() = makeNetworkRequest {
//        doctourApiService.fetchFavorites(userPreferences.userID.toString().toInt()).favoriteTour
//    }
//
//    fun changePassword(
//        email: String,
//        passwordOld: String,
//        passwordNew: String,
//        passwordNewAgain: String
//    ) = makeNetworkRequest {
//        Log.e(
//            "ок", userPreferences.userID.toString()
//        )
//        doctourApiService.changePassword(
//            userPreferences.userID.toString().toInt(),
//            changePasswordDto(
//                email,
//                passwordOld,
//                passwordNew,
//                passwordNewAgain
//            )
//        )
//    }
}