package com.example.doctour.data.remote.pagingsources.сategory

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.ClinicDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.Clinic

class CategoryClinicsPaging(
    private val doctourApiService: DoctourApiService,
    private val pageSize:Int,
    private val search:String,
    private val subServiceClinic:String,
    private val city:String
) :BasePagingSource<ClinicDt,Clinic>({page->
    doctourApiService.getClinics(page,pageSize, search, subServiceClinic, city)
}) {
}