package com.example.doctour.data.remote.pagingsources

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.SpecialtyDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.Speciality

class CategoryDoctorsPagingSource(
    private val doctourApiService: DoctourApiService
):BasePagingSource <SpecialtyDt,Speciality>({
    doctourApiService.getSpecialityOfDoctors(it)
})