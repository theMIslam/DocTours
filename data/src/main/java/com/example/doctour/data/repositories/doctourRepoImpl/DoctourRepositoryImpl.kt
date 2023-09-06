package com.example.doctour.data.repositories.doctourRepoImpl

import androidx.paging.PagingData
import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.model.favoriteClinic.toFavoriteClinicBodyDt
import com.example.doctour.data.model.reviews.toReviewBodyDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.data.remote.pagingsources.doctour.DoctourPagingSource
import com.example.doctour.data.remote.pagingsources.favorite.FavoriteClinicsPagingSource
import com.example.doctour.data.remote.pagingsources.favorite.FavoriteDoctorsPagingSource
import com.example.doctour.data.remote.pagingsources.review.ReviewsPagingSource
import com.example.doctour.data.remote.pagingsources.search.SearchPagingSource
import com.example.doctour.data.remote.pagingsources.subService.SubServicePagingSource
import com.example.doctour.data.remote.pagingsources.сategory.categoryClinics.CategoryClinicsPaging
import com.example.doctour.data.remote.pagingsources.сategory.categoryDoctors.CategoryDoctorsPagingSource
import com.example.doctour.data.remote.pagingsources.сategory.categoryServices.CategoryServicesOfDoctorsPagingSource
import com.example.doctour.domain.model.clinics.Clinic
import com.example.doctour.domain.model.doctorDetail.Doctor
import com.example.doctour.domain.model.doctorDetail.DoctorDetail
import com.example.doctour.domain.model.favoriteClinics.FavoriteClinic
import com.example.doctour.domain.model.favoriteClinics.FavoriteClinicBody
import com.example.doctour.domain.model.favoriteDoctors.FavoriteDoctor
import com.example.doctour.domain.model.reviews.Review
import com.example.doctour.domain.model.reviews.ReviewBody
import com.example.doctour.domain.model.service.Service
import com.example.doctour.domain.model.speciality.Specialty
import com.example.doctour.domain.model.subService.SubService
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
    = doPagingRequest(
        DoctourPagingSource(
        doctourApiService,10,specialties, categoryService, city, search, ordering
    )
    )

    override fun getDoctorsByID(id: String): Flow<Either<NetworkError, DoctorDetail>>
    = doNetworkRequestWithMapping { doctourApiService.getDoctorsByID(id) }

    override fun getClinics(
        search: String,
        subServiceClinic: String,
        city: String
    ): Flow<PagingData<Clinic>>
    =doPagingRequest(
        CategoryClinicsPaging(
        doctourApiService,10,search,subServiceClinic,city)
    )

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
