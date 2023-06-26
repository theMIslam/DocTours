package com.example.doctour.data.remote.apiservices

import com.example.doctour.data.base.BaseResponse
import com.example.doctour.data.model.ClinicsDt
import com.example.doctour.data.model.DoctorDetailDt
import com.example.doctour.data.model.DoctorDt
import com.example.doctour.data.model.FavoriteDt
import com.example.doctour.data.model.PasswordConfirmResetDt
import com.example.doctour.data.model.PasswordResetDt
import com.example.doctour.data.model.ReviewDt
import com.example.doctour.data.model.ServiceDt
import com.example.doctour.data.model.SpecialityDt
import com.example.doctour.data.model.SubServiceClinicsDt
import com.example.doctour.data.model.TokenRefreshDt
import com.example.doctour.data.model.UserLoginDt
import com.example.doctour.data.model.UserRegisterDt
import com.example.doctour.data.model.WhatsappSendDt
import com.example.doctour.data.remote.dtos.doctour.DoctourDto
import com.example.doctour.data.remote.dtos.doctour.DoctourPagingResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DoctourApiService {
    @GET("/api/v1/src/doctors/")
    fun getDoctors(
        @Query("page")page: Int,
        @Query("specialties")specialties:String,
        @Query("clinic")clinic: String,
        @Query("category_service")categoryService:String,
        @Query("city")city:String,
        @Query("search")search: String,
        @Query("ordering")ordering: String
    ):BaseResponse<DoctorDt>
    @GET("/api/v1/src/clinics/")
    fun getClinics(
        @Query("page")page: Int
    ):BaseResponse<ClinicsDt>

    @GET("/api/v1/src/doctors/{id}")
    fun getDoctorsById(
        @Path("id")id:Int
    ):DoctorDetailDt

    @GET("/api/v1/src/reviews/")
    fun getReviews(
        @Query("page")page: Int
    ):BaseResponse<ReviewDt>

    @POST("/api/v1/src/reviews/")
    fun postReviews(
        @Body data:ReviewDt
    ):ResponseBody

    @GET("/api/v1/src/service/")
    fun getCategoryServicesOfDoctors(
        @Query("id")id:Int,
        @Query("name")name:String,
        @Query("price")price:String,
        @Query("search")search:String,
    ):BaseResponse<ServiceDt>

    @GET("/api/v1/src/service/clinics/")
    fun getCategoryServicesOfClinics(
        @Query("id")id:Int
    ):BaseResponse<SubServiceClinicsDt>

    @GET("/api/v1/src/speciality/")
    fun getSpecialityOfDoctors(
        @Query("id")id:Int
    ):BaseResponse<SpecialityDt>

    @POST("/api/v1/src/whatsapp-send/")
    fun postWhatsappSend(
        @Body data:WhatsappSendDt
    ):ResponseBody

    @GET("/api/v1/users/favorites/")
    fun getFavorites(
        @Query("page")page: Int
    ):BaseResponse<FavoriteDt>

    @POST("/api/v1/users/favorites/")
    fun postFavorites(
        @Body data:FavoriteDt
    ):ResponseBody

    @GET("/api/v1/users/logout/")
    fun logOut()

    @POST("/api/v1/users/password-reset/confirm/{token}/api_v1_users_password-reset_confirm_create")
    fun postPasswordConfirmReset(
        @Body data:PasswordConfirmResetDt,
        @Path("token") token:String
    ):ResponseBody

    @POST("/api/v1/users/reset/")
    fun postReset(
        @Body data:PasswordResetDt
    ):ResponseBody

    @POST("/api/v1/users/signin/")
    fun postSignIn(
        @Body data:UserLoginDt
    ):ResponseBody

    @POST("/api/v1/users/signup/")
    fun postFavorites(
        @Body data:UserRegisterDt
    ):ResponseBody

    @POST("/api/v1/users/token-refresh/")
    fun postTokenRefresh(
        @Body data:TokenRefreshDt
    ):ResponseBody

    @GET("/api/foo")
    suspend fun fetchDoctour(): Response<DoctourDto>

    @GET("/api/foo")
    suspend fun fetchDoctourPaging(
        @Query("page") page: Int
    ): Response<DoctourPagingResponse<DoctourDto>>
}