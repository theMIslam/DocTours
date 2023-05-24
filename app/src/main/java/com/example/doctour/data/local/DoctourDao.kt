package com.example.doctour.data.local

import androidx.room.*
import com.example.doctour.data.model.DoctourEntity

@Dao
interface DoctourDao {
    // CRUD
    // C - create
    // R - read
    // U - update
    // D - delete

    @Insert
    suspend fun createDoctour(doctourEntity: DoctourEntity)

    @Query("SELECT * FROM doctour")
    suspend fun getAllDoctour(): List<DoctourEntity>

    @Update
    suspend fun editDoctour(doctourEntity: DoctourEntity)

    @Delete
    suspend fun deleteDoctour(doctourEntity: DoctourEntity)
}