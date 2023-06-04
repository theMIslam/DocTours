package com.example.doctour.data.repositories

import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.data.remote.pagingsources.DoctourPagingSource
import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.local.db.daos.DoctourDao
import com.example.doctour.data.local.db.entities.doctour.toEntity
import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

abstract class DoctourRepositoryImpl @Inject constructor(
    private val service: DoctourApiService,
    private val dao: DoctourDao
) : BaseRepository(), DoctourRepository {

    fun fetchFoo() = doNetworkRequestWithMapping {
        service.fetchDoctour().onSuccess { data ->
            dao.insertDoctour(data.toEntity())
        }
    }

    fun getFoo() = doLocalRequestForList { dao.getAllDoctour() }

    fun fetchFooPaging() = doPagingRequest({ DoctourPagingSource(service) })
}