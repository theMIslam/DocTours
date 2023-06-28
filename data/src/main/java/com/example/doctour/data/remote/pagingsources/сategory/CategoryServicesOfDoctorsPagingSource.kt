package com.example.doctour.data.remote.pagingsources.сategory

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.ServiceDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.Service

class CategoryServicesOfDoctorsPagingSource(
    private val doctourApiService: DoctourApiService,
    private val name:String?,
    private val price:String?,
    private val search:String?
)
    :BasePagingSource< ServiceDt,Service>({
        doctourApiService.getCategoryServicesOfDoctors(it,name, price, search)
})