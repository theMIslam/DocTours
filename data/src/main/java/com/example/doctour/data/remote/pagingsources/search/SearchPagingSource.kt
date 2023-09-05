package com.example.doctour.data.remote.pagingsources.search

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.DoctorDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.doctorDetail.Doctor
class SearchPagingSource(
    private val doctourApiService: DoctourApiService,
    private val search: String?
) : BasePagingSource<DoctorDt, Doctor>({ page ->
    doctourApiService.search(page,search)
})