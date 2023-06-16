package com.example.doctour.data.repositories

import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.local.db.daos.DoctourDao
import com.example.doctour.data.remote.apiService.auth.AuthenticationApiService
import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

abstract class DoctourRepositoryImpl @Inject constructor(
    private val service: AuthenticationApiService,
    private val dao: DoctourDao
) : BaseRepository(), DoctourRepository {

//
//    override fun getDoctour() = doLocalRequestForList { dao.getAllDoctour() }
//
//    override fun fetchDoctourPaging() = doPagingRequest({ DoctourPagingSource(service) })
}