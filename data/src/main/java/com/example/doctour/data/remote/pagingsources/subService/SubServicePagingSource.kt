package com.example.doctour.data.remote.pagingsources.subService

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.SubServiceDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.subService.SubService

class SubServicePagingSource (
    private val doctourApiService: DoctourApiService,
    private val clinic:String,
    private val service:String,
    private val search:String
        ):BasePagingSource<SubServiceDt, SubService>({ page ->
            doctourApiService.getSubService(clinic,service,search,page)
})