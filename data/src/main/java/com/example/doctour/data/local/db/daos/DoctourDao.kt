package com.example.doctour.data.local.db.daos

import androidx.room.*
import com.example.doctour.data.local.db.entities.doctour.DoctourEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DoctourDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDoctour(foo: DoctourEntity)

    @Query("SELECT * FROM doctour")
    fun getAllDoctour(): Flow<List<DoctourEntity>>
}
