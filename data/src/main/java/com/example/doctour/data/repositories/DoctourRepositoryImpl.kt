package com.example.doctour.data.repositories

import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.data.remote.pagingsources.DoctourPagingSource
import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.local.db.daos.DoctourDao
import com.example.doctour.data.local.db.entities.doctour.toEntity
import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class DoctourRepositoryImpl @Inject constructor(
    private val service: DoctourApiService,
    private val dao: DoctourDao
) : BaseRepository(), DoctourRepository {

    override fun fetchDoctour() = doNetworkRequestWithMapping {
        service.fetchDoctour().onSuccess { data ->
            dao.insertDoctour(data.toEntity())
        }
    }

    override fun getDoctour() = doLocalRequestForList { dao.getAllDoctour() }

    override fun fetchDoctourPaging() = doPagingRequest({ DoctourPagingSource(service) })
}