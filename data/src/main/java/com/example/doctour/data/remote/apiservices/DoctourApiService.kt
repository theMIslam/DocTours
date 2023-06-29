package com.example.doctour.data.remote.apiservices

import com.example.doctour.data.base.BaseResponse
import com.example.doctour.data.model.ClinicDt
import com.example.doctour.data.model.DoctorDetailDt
import com.example.doctour.data.model.DoctorDt
import com.example.doctour.data.model.FavoriteDt
import com.example.doctour.data.model.PasswordConfirmResetDt
import com.example.doctour.data.model.PasswordResetDt
import com.example.doctour.data.model.ReviewDt
import com.example.doctour.data.model.ServiceDt
import com.example.doctour.data.model.SpecialtyDt
import com.example.doctour.data.model.SubServiceClinicsDt
import com.example.doctour.data.model.TokenRefreshDt
import com.example.doctour.data.model.UserLoginDt
import com.example.doctour.data.model.UserRegisterDt
import com.example.doctour.data.model.WhatsappSendDt
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DoctourApiService {
    @GET("/api/v1/src/doctors/")
   suspend fun getAllDoctors(
        @Query("page")page: Int,
        @Query("specialties")specialties:String?,
        @Query("clinic")clinic: String?,
        @Query("category_service")categoryService:String?,
        @Query("city")city:String?,
        @Query("search")search: String?,
        @Query("ordering")ordering: String?
    ):Response<BaseResponse<DoctorDt>>
    @GET("api/v1/src/doctors/")
    suspend fun getDoctors(
        @Query("page")page: Int
    ):BaseResponse<DoctorDt>

    @GET("/api/v1/src/clinics/")
   suspend fun getClinics(
        @Query("page")page: Int
    ):Response<BaseResponse<ClinicDt>>

    @GET("/api/v1/src/doctors/{id}")
   suspend fun getDoctorsById(
        @Path("id")id:Int
    ):DoctorDetailDt

    @GET("/api/v1/src/reviews/")
   suspend fun getReviews(
        @Query("page")page: Int
    ):Response<BaseResponse<ReviewDt>>

    @POST("/api/v1/src/reviews/")
   suspend fun postReviews(
        @Body data:ReviewDt
    ):ResponseBody

    @GET("/api/v1/src/service/")
   suspend fun getCategoryServicesOfDoctors(
        @Query("id")id:Int,
        @Query("name")name:String?,
        @Query("price")price:String?,
        @Query("search")search:String?,
    ):Response<BaseResponse<ServiceDt>>

    @GET("api/v1/src/service/clinics/")
   suspend fun getCategoryServicesOfClinics(
        @Query("id")id:Int
    ):BaseResponse<SubServiceClinicsDt>

    @GET("api/v1/src/speciality/")
   suspend fun getSpecialityOfDoctors(
        @Query("page")page:Int
    ):Response<BaseResponse<SpecialtyDt>>

    @POST("/api/v1/src/whatsapp-send/")
    fun postWhatsappSend(
        @Body data:WhatsappSendDt
    ):ResponseBody

    @GET("api/v1/users/favorites/")
   suspend fun getFavorites(
        @Query("page")page: Int
    ):BaseResponse<FavoriteDt>

    @POST("/api/v1/users/favorites/")
   suspend fun postFavorites(
        @Body data:FavoriteDt
    ):ResponseBody

    @GET("/api/v1/users/logout/")
   suspend fun logOut()

    @POST("/api/v1/users/password-reset/confirm/{token}/api_v1_users_password-reset_confirm_create")
   suspend fun postPasswordConfirmReset(
        @Body data:PasswordConfirmResetDt,
        @Path("token") token:String
    ):ResponseBody

    @POST("/api/v1/users/reset/")
   suspend fun postReset(
        @Body data:PasswordResetDt
    ):ResponseBody

    @POST("/api/v1/users/signin/")
   suspend fun postSignIn(
        @Body data:UserLoginDt
    ):ResponseBody

    @POST("/api/v1/users/signup/")
   suspend fun postFavorites(
        @Body data:UserRegisterDt
    ):ResponseBody

    @POST("/api/v1/users/token-refresh/")
   suspend fun postTokenRefresh(
        @Body data:TokenRefreshDt
    ):ResponseBody

//    @GET("/api/foo")
//    suspend fun fetchDoctour(): Response<DoctourDto>
//
//    @GET("/api/foo")
//    suspend fun fetchDoctourPaging(
//        @Query("page") page: Int
//    ): Response<DoctourPagingResponse<DoctourDto>>
}