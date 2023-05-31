package com.example.doctour.data.repository

import android.util.Log
import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.local.pref.UserPreferences
import com.example.doctour.data.remote.apiService.user.UserApiService
import com.example.doctour.data.remote.dto.ChangeUsernameOrEmailDto
import com.example.doctour.data.remote.dto.changePassword.ChangePasswordDto
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userApiService: UserApiService,
    private val userPreferences: UserPreferences
) : BaseRepository() {

    fun getUserProfile(id: Int = userPreferences.userID.toString().toInt()) = makeNetworkRequest {
        userApiService.getUserProfile(id)
    }

    fun deleteAccount() = makeNetworkRequest {
        userApiService.deleteAccount(
            userPreferences.userID.toString().toInt()
        )
    }

    fun getFavoriteTours() = makeNetworkRequest {
        userApiService.fetchFavorites(userPreferences.userID.toString().toInt()).favoriteTour
    }

    fun changePassword(
        email: String,
        passwordOld: String,
        passwordNew: String,
        passwordNewAgain: String
    ) = makeNetworkRequest {
        Log.e(
            "ок", userPreferences.userID.toString()
        )
        userApiService.changePassword(
            userPreferences.userID.toString().toInt(),
            ChangePasswordDto(
                email,
                passwordOld,
                passwordNew,
                passwordNewAgain
            )
        )
    }

    fun changeUsernameOrPassword(username: String, email: String) = makeNetworkRequest {
        userApiService.changeUsernameOrEmail(ChangeUsernameOrEmailDto(username, email))
    }
}