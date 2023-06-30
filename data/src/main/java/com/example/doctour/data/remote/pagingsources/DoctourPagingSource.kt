package com.example.doctour.data.remote.pagingsources

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.DoctorDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.Doctor
import com.example.doctour.domain.model.DoctorResponse

class DoctourPagingSource(
    private val doctourApiService: DoctourApiService,
    private val specialties: String?,
    private val clinic: String?,
    private val categoryService: String?,
    private val city: String?,
    private val  search: String?,
    private val ordering: String?
) : BasePagingSource<DoctorDt,Doctor>(
    {
        doctourApiService.getAllDoctors(it,specialties, clinic, categoryService, city, search, ordering)
    }
)