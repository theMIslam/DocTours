package com.example.doctour.data.remote.pagingsources

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.data.remote.dtos.doctour.DoctourDto
import com.example.doctour.domain.model.local.Doctour

class DoctourPagingSource(
    private val service: DoctourApiService
) : BasePagingSource<DoctourDto, Doctour>(
    { service.fetchDoctourPaging(it) }
)