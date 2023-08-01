package com.example.doctour.data.remote.apiservices

import com.example.doctour.data.base.BaseResponse
import com.example.doctour.data.model.ClinicDt
import com.example.doctour.data.model.DoctorDetailDt
import com.example.doctour.data.model.DoctorDt
import com.example.doctour.data.model.FavoriteClinicBodyDt
import com.example.doctour.data.model.FavoriteClinicDt
import com.example.doctour.data.model.FavoriteDoctorDt
import com.example.doctour.data.model.ReviewBodyDt
import com.example.doctour.data.model.ReviewDt
import com.example.doctour.data.model.ServiceDt
import com.example.doctour.data.model.SpecialtyDt
import com.example.doctour.data.model.SubServiceDt
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DoctourApiService {
    @GET("/api/v1/src/doctors/")
    suspend fun getDoctors(
        @Query("page") page: Int,
        @Query("page_size")pageSize:Int,
        @Query("search") search: String?,
        @Query("ordering") ordering: String?,
        @Query("city") city: String?,
        @Query("category_service") categoryService: String?,
        @Query("specialties") specialties: String?
    ): Response<BaseResponse<DoctorDt>>

    @GET("/api/v1/src/clinics/")
    suspend fun getClinics(
        @Query("page") page: Int,
        @Query("page_size")pageSize:Int,
        @Query("search") search: String?,
        @Query("subservice_clinic") subServiceClinic: String?,
        @Query("city") city: String?
    ): Response<BaseResponse<ClinicDt>>

    @GET("/api/v1/src/doctors/{id}")
    suspend fun getDoctorsByID(
        @Path("id") id :String
    ):Response<DoctorDetailDt>

    //////  FAVORITE CLINIC
    @GET("/api/v1/src/favorites-clinics/")
    suspend fun getFavoriteClinics(
        @Query("page")page: Int
    ):Response<BaseResponse<FavoriteClinicDt>>

    @POST("/api/v1/src/favorites-clinics/")
    suspend fun postFavoriteClinics(
        @Body data :FavoriteClinicBodyDt
    ):Response<FavoriteClinicDt>

    @GET("/api/v1/src/favorites-clinics/{id}/")
    suspend fun getFavoriteClinicsByID(
        @Path("id") id :Int
    ):Response<FavoriteDoctorDt>

    @DELETE("/api/v1/src/favorites-clinics/{id}/")
    suspend fun deleteFavoriteClinicsByID(
        @Path("id")id:Int
    )

    /////  FAVORITE DOCTOR
    @GET("/api/v1/src/favorites-doctors/")
    suspend fun getFavoriteDoctors(
        @Query("page")page:Int
    ):Response<BaseResponse<FavoriteDoctorDt>>

    @POST("/api/v1/src/favorites-doctors/")
    suspend fun postFavoriteDoctors(
        @Body data:FavoriteClinicBodyDt
    ):Response<FavoriteDoctorDt>

    @GET("/api/v1/src/favorites-doctors/{id}/")
    suspend fun getFavoriteDoctorsByID(
        @Path("id")id: Int
    ):Response<FavoriteDoctorDt>

    @DELETE("/api/v1/src/favorites-doctors/{id}/")
    suspend fun deleteFavoriteDoctorsByID(
        @Path("id")id: Int
    )
    //////REVIEW
    @GET("/api/v1/src/reviews/")
    suspend fun getReviews(
       @Query("page")page: Int
    ):Response<BaseResponse<ReviewDt>>

    @POST("/api/v1/src/reviews/")
    suspend fun postReviews(
        @Body data:ReviewBodyDt
    ):Response<ReviewDt>

    /////////SEARCH BY CITY
    @GET("/api/v1/src/search-by-city/{id}/")
    suspend fun searchByID(
        @Path("id")id:String)

    //////SERVICE
    @GET("/api/v1/src/service/")
    suspend fun getServiceOfDoctor(
        @Query("search")search:String,
        @Query("page")page: Int
    ):Response<BaseResponse<ServiceDt>>

    @GET("/api/v1/src/sub-service/")
    suspend fun getSubService(
        @Query("clinic")clinic:String,
        @Query("service")service:String,
        @Query("search")search:String,
        @Query("page")page:Int,
    ):Response<BaseResponse<SubServiceDt>>

    ///SPECIALITY
    @GET("/api/v1/src/speciality/")
    suspend fun getSpeciality(
        @Query("search") search:String,
        @Query("page") page:Int,
        @Query("page_size") page_size:Int
    ):Response<BaseResponse<SpecialtyDt>>

    ////////////// SEARCH
    @GET("/search/")
    suspend fun search(
        @Query("page") page: Int,
        @Query("search") search: String?
        ): Response<BaseResponse<DoctorDt>>
}