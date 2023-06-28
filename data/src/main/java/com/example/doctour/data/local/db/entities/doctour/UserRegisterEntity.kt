package com.example.doctour.data.local.db.entities.doctour

import androidx.room.Entity

@Entity(tableName = "register")
class UserRegisterEntity(
    val password: String?,
    val username: String?,
    val surname: String?,
    val lastname: String?,
    val phone: Int?,
    val gender: String?,
    val birthday: String?
)
