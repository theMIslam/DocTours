package com.example.doctour.domain.repositories

import androidx.paging.PagingData
import com.example.doctour.domain.model.Clinics
import com.example.doctour.domain.model.Doctor
import com.example.doctour.domain.model.Review
import com.example.doctour.domain.model.Service
import com.example.doctour.domain.model.Speciality
import com.example.doctour.domain.model.TokenRefresh
import com.example.doctour.domain.model.UserLogin
import com.example.doctour.domain.model.WriteReview
import com.example.doctour.domain.utils.Either
import com.example.doctour.domain.utils.NetworkError
import com.example.doctour.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RemoteDoctorRepository {

    fun postLogin( phone_number:String,password:String):Flow<Either<String,TokenRefresh>>

    fun writeReview(data:WriteReview):Flow<Either<String,Review>>

    fun getAllDoctors(
        specialties: String?,
        clinic: String?,
        categoryService: String?,
        city: String?,
        search: String?,
        ordering: String?
    ): Flow<PagingData<Doctor>>

    fun getSpecialityOfDoctors():Flow<PagingData<Speciality>>

    fun  getClinics():Flow<PagingData<Clinics>>

    fun getCategoryServicesOfDoctors(
        name:String?,
        price:String?,
        search:String?
    ):Flow<PagingData<Service>>

    fun getReviews():Flow<PagingData<Review>>

    fun searchByTitle(
        search: String?
    ):Flow<PagingData<Doctor>>

}