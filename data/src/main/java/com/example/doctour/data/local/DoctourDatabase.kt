package com.example.doctour.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.doctour.data.model.DoctourEntity

@Database(entities = [DoctourEntity::class], version = 1,)
abstract class DoctourDatabase: RoomDatabase() {

    abstract fun doctourDao(): DoctourDao

}