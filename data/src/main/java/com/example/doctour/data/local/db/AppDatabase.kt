package com.example.doctour.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.doctour.data.local.daos.DoctourDao
import com.example.doctour.data.local.entities.doctour.DoctourEntity

@Database(entities = [DoctourEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun doctourDao(): DoctourDao
}
