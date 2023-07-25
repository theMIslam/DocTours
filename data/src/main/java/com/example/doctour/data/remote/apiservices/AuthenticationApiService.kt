package com.example.doctour.data.remote.apiservices

import com.example.doctour.data.base.BaseResponse
import com.example.doctour.data.model.PasswordResetNewPasswordDt
import com.example.doctour.data.model.PasswordResetSearchUserDt
import com.example.doctour.data.model.PasswordResetTokenDt
import com.example.doctour.data.model.ProfileDt
import com.example.doctour.data.model.TokenRefreshBodyDt
import com.example.doctour.data.model.TokenRefreshDt
import com.example.doctour.data.model.UserConfirmDt
import com.example.doctour.data.model.UserLoginDt
import com.example.doctour.data.model.UserRegistrationDt
import com.example.doctour.data.model.WhatsappSendDt
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthenticationApiService {

    ///////////// LOGIN
    @POST("/api/v1/users/login/")
    suspend fun userLogin(
        @Body data: UserLoginDt
    ): Response<UserLoginDt>

    /////////// REGISTER USER
    @POST("/api/v1/users/register/")
    suspend fun  registerUser(
        @Body data :UserRegistrationDt
    ):Response<UserRegistrationDt>

    /////////TOKEN REFRESH
    @POST("/api/v1/users/login/token/refresh/")
    suspend fun tokenRefresh(
        @Body data:TokenRefreshBodyDt
    ):Response<TokenRefreshDt>

    ////////// ДЛЯ ВВЕДЕНИЯ ТОКЕНА
    @POST("/api/v1/users/reset-password-code/")
    suspend fun resetPasswordCode(
        @Body data :PasswordResetTokenDt
    ):Response<PasswordResetTokenDt>

    ////////WHATS APP
    @POST("/api/v1/src/whatsapp-send/")
    suspend fun postWhatsAppEnrol(
        @Body data: WhatsappSendDt
    ): Response<WhatsappSendDt>

    ///////////USER CONFIRM
    @POST("/api/v1/users/confirm-user/")
    suspend fun userConfirm(
        @Body data: UserConfirmDt
    ): Response<UserConfirmDt>

    ///////////// LOG OUT
    @GET("/api/v1/users/logout/")
    suspend fun userLogOut()

    ////////////  GET USER PROFILE
    @GET("/api/v1/users/profile/")
    suspend fun getUserProfile(
        @Query("page")page:Int
    ):Response<BaseResponse<ProfileDt>>

    ////////////  GET USER PROFILE BY ID
    @GET("/api/v1/users/profile/{id}/")
    suspend fun getUserProfileByID(
        @Path("id")id:String
    ):Response<ProfileDt>

    ////////// PUT USER PROFILE BY ID
    @PUT("/api/v1/users/profile/{id}/")
    suspend fun putUsersProfileByID(
        @Body data:ProfileDt,
        @Path ("id")id:String
    ):Response<ProfileDt>

    //////// PATCH USER PROFILE BY ID
    @PATCH("/api/v1/users/profile/{id}/")
    suspend fun patchUsersProfileByID(
        @Body data:ProfileDt,
        @Path ("id") id:String
    ):Response<ProfileDt>

    //////// DELETE USERS PROFILE BY ID
    @DELETE("/api/v1/users/profile/{id}/")
    suspend fun deleteUserProfileById(
        @Path ("id")id:String)

    ///////////  ДЛЯ СБРОСА ПАРОЛЯ
    @POST("/api/v1/users/reset-new_password/{code}/")
    suspend fun resetNewPassword(
        @Body data: PasswordResetNewPasswordDt,
        @Path ( "code")code:String
    ):Response<PasswordResetNewPasswordDt>

    ///////////  ДЛЯ ПОИСКА USER  И СОЗДАНИЕ КОДА
    @POST("api/v1/users/reset-password-phone_number/")
    suspend fun searchUserAndCreateCode(
        @Body data :PasswordResetSearchUserDt
    ):Response<PasswordResetSearchUserDt>


    //////////         OLD REQUESTS  ////////////////////

//    @POST("/api/v1/users/register/")
//    suspend fun postRegister(
//        @Body data: UserRegistrationDt
//    ): Response<UserRegistrationDt>
//
//    @POST("/api/v1/users/confirm-user/")
//    suspend fun confirmUser(@Body data: UserConfirmDt): Response<UserConfirmDt>
//
//    @POST("/api/v1/users/login/")
//    suspend fun postLogin( @Body data: UserLoginDt): Response<TokenRefreshAccessDt>
//
//    @GET("/api/v1/users/logout/")
//    suspend fun logOut()
//
//    @POST("/api/v1/users/login/token/refresh/")
//    suspend fun refreshToken(
//        //@Header("Authorization") token: String
//        @Header("Authorization") data: RefreshTokenDt
//    ): Response<TokenRefreshAccessDt>
}