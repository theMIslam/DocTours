package com.example.doctour.data.local.db

import android.content.Context
import androidx.room.Room
import com.example.doctour.data.local.db.daos.DoctourDao

class RoomClient {
    fun provideAppDatabase(context: Context) = Room
        .databaseBuilder(context, AppDatabase::class.java, "doctour.db")
        .build()

    fun provideFooDao(appDatabase: AppDatabase): DoctourDao = appDatabase.doctourDao()
}
