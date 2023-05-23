package com.example.doctour.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("doctour")
class DoctourEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val tittle : String? = null,
    val description : String? = null
)