package com.example.doctour.domain.repositories

import androidx.paging.PagingData
import com.example.doctour.domain.model.Clinic
import com.example.doctour.domain.model.Doctor
import com.example.doctour.domain.model.DoctorDetail
import com.example.doctour.domain.model.FavoriteClinic
import com.example.doctour.domain.model.FavoriteClinicBody
import com.example.doctour.domain.model.FavoriteDoctor
import com.example.doctour.domain.model.Review
import com.example.doctour.domain.model.ReviewBody
import com.example.doctour.domain.model.Service
import com.example.doctour.domain.model.Specialty
import com.example.doctour.domain.model.SubService
import com.example.doctour.domain.utils.Either
import com.example.doctour.domain.utils.NetworkError
import kotlinx.coroutines.flow.Flow

interface DoctourRepository {
    /////////////  DOCTORS
    fun getDoctors(
        search: String?,
        ordering: String?,
        city: String?,
        categoryService: String?,
        specialties: String?
    ): Flow<PagingData<Doctor>>
    fun getDoctorsByID(id :String):Flow<Either<NetworkError,DoctorDetail>>

    /////////////  CLINICS
    fun getClinics(
        search: String,
        subServiceClinic: String,
        city: String
    ): Flow<PagingData<Clinic>>

    ////// FAVORITE CLINIC
    fun getFavoriteClinics():Flow<PagingData<FavoriteClinic>>
    fun postFavoriteClinics(data :FavoriteClinicBody):Flow<Either<NetworkError,FavoriteClinic>>
    fun getFavoriteClinicsByID(id :Int):Flow<Either<NetworkError,FavoriteDoctor>>
    fun deleteFavoriteClinicsByID(id:Int):Flow<Either<String,Unit>>

    /////  FAVORITE DOCTOR
    fun getFavoriteDoctors():Flow<PagingData<FavoriteDoctor>>
    fun postFavoriteDoctors(data:FavoriteClinicBody):Flow< Either<NetworkError,FavoriteDoctor>>
    fun getFavoriteDoctorsByID(id: Int):Flow<Either<NetworkError,FavoriteDoctor>>
    fun deleteFavoriteDoctorsByID(id: Int):Flow<Either<String,Unit>>

    //////REVIEW
    fun getReviews():Flow<PagingData<Review>>
    fun postReviews(data:ReviewBody):Flow<Either<NetworkError,Review>>

    /////////SEARCH BY CITY
    fun searchCityByID(id:String):Flow<Either<String,Unit>>

    //////SERVICE
    fun getServiceOfDoctor(search:String):Flow<PagingData<Service>>
    fun getSubService(clinic:String,service:String, search:String):Flow<PagingData<SubService>>

    ///SPECIALITY
    fun getSpeciality(search:String):Flow<PagingData<Specialty>>

    ////////////// SEARCH
    fun search(search: String?):Flow<PagingData<Doctor>>

}
