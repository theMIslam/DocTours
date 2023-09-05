package com.example.doctour.data.remote.pagingsources.сategory

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.service.ServiceDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.service.Service

class CategoryServicesOfDoctorsPagingSource(
    private val doctourApiService: DoctourApiService,
    private val search:String
) :BasePagingSource<ServiceDt, Service>({ page ->
        doctourApiService.getServiceOfDoctor(search,page)
})