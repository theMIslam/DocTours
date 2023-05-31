package com.example.doctour.data.repository.tours

import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.remote.remoteDataSource.RemoteDataSource
import javax.inject.Inject

class SearchRepository @Inject constructor(private val dataSource: RemoteDataSource) :
    BaseRepository() {

    fun getSlugs() = doRequest { dataSource.getSlugs() }
}