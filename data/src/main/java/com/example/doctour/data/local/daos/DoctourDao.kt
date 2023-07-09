package com.example.doctour.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.doctour.data.local.entities.doctour.DoctourEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface DoctourDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDoctour(foo: DoctourEntity)

    @Query("SELECT * FROM doctour")
    fun getAllDoctour(): Flow<List<DoctourEntity>>
}
