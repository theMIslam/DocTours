package com.example.doctour.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.doctour.data.local.db.entities.doctour.UserRegisterEntity
import com.example.doctour.data.remote.apiservices.UserRegisterApiService

class UserRegisterVIewModel: ViewModel(){

    fun usersRegister(): LiveData<UserRegisterEntity> {
        return postUserRegister()
    }

    private fun postUserRegister(): LiveData<UserRegisterEntity> {

        //UserRegisterApiService.usersRegister
    }
}