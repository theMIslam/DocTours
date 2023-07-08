package com.example.doctour.data.repositories

import androidx.paging.PagingData
import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.model.toReviewDt
import com.example.doctour.data.model.toWriteReviewDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.data.remote.pagingsources.сategory.CategoryClinicsPaging
import com.example.doctour.data.remote.pagingsources.сategory.CategoryDoctorsPagingSource
import com.example.doctour.data.remote.pagingsources.сategory.CategoryServicesOfDoctorsPagingSource
import com.example.doctour.data.remote.pagingsources.DoctourPagingSource
import com.example.doctour.data.remote.pagingsources.ReviewsPagingSource
import com.example.doctour.data.remote.pagingsources.SearchPagingSource
import com.example.doctour.domain.model.Clinics
import com.example.doctour.domain.model.Doctor
import com.example.doctour.domain.model.Review
import com.example.doctour.domain.model.Service
import com.example.doctour.domain.model.WriteReview
import com.example.doctour.domain.repositories.RemoteDoctorRepository
import com.example.doctour.domain.utils.Either
import com.example.doctour.domain.utils.NetworkError
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DoctourRepositoryImpl @Inject constructor(
    private val doctourApiService: DoctourApiService
) : RemoteDoctorRepository, BaseRepository() {

    override fun writeReview(data: WriteReview): Flow<Either<String, Review>>
    = makeNetworkRequest { doctourApiService.postReviews(data.toWriteReviewDt()).mapToDomain() }

    override fun searchByTitle(
        search: String?
    ): Flow<PagingData<Doctor>> = doPagingRequest(
        SearchPagingSource(doctourApiService,search)
    )

    override fun getAllDoctors(
        specialties: String?,
        clinic: String?,
        categoryService: String?,
        city: String?,
        search: String?,
        ordering: String?
    ) = doPagingRequest(
        DoctourPagingSource(
            doctourApiService,
            specialties,
            clinic,
            categoryService,
            city,
            search,
            ordering
        )
    )

    override fun getSpecialityOfDoctors() =
        doPagingRequest(CategoryDoctorsPagingSource(doctourApiService))

    override fun getClinics(): Flow<PagingData<Clinics>> {
        return doPagingRequest(CategoryClinicsPaging(doctourApiService))
    }

    override fun getCategoryServicesOfDoctors(
        name: String?,
        price: String?,
        search: String?
    ): Flow<PagingData<Service>> {
        return doPagingRequest(
            CategoryServicesOfDoctorsPagingSource(
                doctourApiService,
                name,
                price,
                search
            )
        )
    }

    override fun getReviews(): Flow<PagingData<Review>> {
        return doPagingRequest(ReviewsPagingSource(doctourApiService))
    }
}
