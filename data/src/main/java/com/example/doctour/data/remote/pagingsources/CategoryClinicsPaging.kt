package com.example.doctour.data.remote.pagingsources

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.ClinicDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.Clinics

class CategoryClinicsPaging(
    private val doctourApiService: DoctourApiService
) :BasePagingSource<ClinicDt,Clinics>({
    doctourApiService.getClinics(it)
}) {
}