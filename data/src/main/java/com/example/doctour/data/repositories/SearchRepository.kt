package com.example.doctour.data.repositories

import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.remote.remoteDataSource.RemoteDataSource
import javax.inject.Inject

class SearchRepository @Inject constructor(private val dataSource: RemoteDataSource) : BaseRepository() {

    fun getSlugs() = doRequest { dataSource.getSlugs() }
}