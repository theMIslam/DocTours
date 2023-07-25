package com.example.doctour.data.repositories

import androidx.paging.PagingData
import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.model.toFavoriteClinicBodyDt
import com.example.doctour.data.model.toReviewBodyDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.data.remote.pagingsources.DoctourPagingSource
import com.example.doctour.data.remote.pagingsources.FavoriteClinicsPagingSource
import com.example.doctour.data.remote.pagingsources.FavoriteDoctorsPagingSource
import com.example.doctour.data.remote.pagingsources.ReviewsPagingSource
import com.example.doctour.data.remote.pagingsources.SearchPagingSource
import com.example.doctour.data.remote.pagingsources.SubServicePagingSource
import com.example.doctour.data.remote.pagingsources.сategory.CategoryClinicsPaging
import com.example.doctour.data.remote.pagingsources.сategory.CategoryDoctorsPagingSource
import com.example.doctour.data.remote.pagingsources.сategory.CategoryServicesOfDoctorsPagingSource
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
import com.example.doctour.domain.repositories.DoctourRepository
import com.example.doctour.domain.utils.Either
import com.example.doctour.domain.utils.NetworkError
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DoctourRepositoryImpl @Inject constructor(
    private val doctourApiService: DoctourApiService
) : DoctourRepository, BaseRepository() {

    override fun deleteFavoriteClinicsByID(id: Int): Flow<Either<String,Unit>>
    = makeNetworkRequest { doctourApiService.deleteFavoriteClinicsByID(id) }

    override fun deleteFavoriteDoctorsByID(id: Int): Flow<Either<String,Unit>>
    = makeNetworkRequest { doctourApiService.deleteFavoriteDoctorsByID(id) }

    override fun getDoctors(
        search: String?,
        ordering: String?,
        city: String?,
        categoryService: String?,
        specialties: String?
    ): Flow<PagingData<Doctor>>
    = doPagingRequest(DoctourPagingSource(
        doctourApiService,10,specialties, categoryService, city, search, ordering
    ))

    override fun getDoctorsByID(id: String): Flow<Either<NetworkError, DoctorDetail>>
    = doNetworkRequestWithMapping { doctourApiService.getDoctorsByID(id) }

    override fun getClinics(
        search: String,
        subServiceClinic: String,
        city: String
    ): Flow<PagingData<Clinic>>
    =doPagingRequest(CategoryClinicsPaging(
        doctourApiService,10,search,subServiceClinic,city))

    override fun getFavoriteClinics(): Flow<PagingData<FavoriteClinic>>
    = doPagingRequest(FavoriteClinicsPagingSource(doctourApiService))

    override fun postFavoriteClinics(data: FavoriteClinicBody): Flow<Either<NetworkError, FavoriteClinic>>
    = doNetworkRequestWithMapping { doctourApiService.postFavoriteClinics(data.toFavoriteClinicBodyDt()) }

    override fun getFavoriteClinicsByID(id: Int): Flow<Either<NetworkError, FavoriteDoctor>>
    =doNetworkRequestWithMapping { doctourApiService.getFavoriteClinicsByID(id) }

    override fun getFavoriteDoctors(): Flow<PagingData<FavoriteDoctor>>
    =doPagingRequest(FavoriteDoctorsPagingSource(doctourApiService))

    override fun postFavoriteDoctors(data: FavoriteClinicBody): Flow<Either<NetworkError, FavoriteDoctor>>
    = doNetworkRequestWithMapping { doctourApiService.postFavoriteDoctors(data.toFavoriteClinicBodyDt()) }

    override fun getFavoriteDoctorsByID(id: Int): Flow<Either<NetworkError, FavoriteDoctor>>
    = doNetworkRequestWithMapping { doctourApiService.getFavoriteDoctorsByID(id) }

    override fun postReviews(data: ReviewBody): Flow<Either<NetworkError, Review>>
    = doNetworkRequestWithMapping { doctourApiService.postReviews(data.toReviewBodyDt()) }

    override fun searchCityByID(id: String): Flow<Either<String,Unit>>
    =makeNetworkRequest { doctourApiService.searchByID(id) }

    override fun getServiceOfDoctor(search: String): Flow<PagingData<Service>>
    = doPagingRequest(CategoryServicesOfDoctorsPagingSource(doctourApiService,search))

    override fun getSubService(
        clinic: String,
        service: String,
        search: String
    ): Flow<PagingData<SubService>>
    = doPagingRequest(SubServicePagingSource(doctourApiService,clinic, service, search))

    override fun getSpeciality(search: String): Flow<PagingData<Specialty>>
    =doPagingRequest(CategoryDoctorsPagingSource(doctourApiService,search,10))

    override fun search(search: String?): Flow<PagingData<Doctor>>
    = doPagingRequest(SearchPagingSource(doctourApiService,search))

    override fun getReviews(): Flow<PagingData<Review>> {
        return doPagingRequest(ReviewsPagingSource(doctourApiService))
    }
}
