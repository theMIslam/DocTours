package com.example.doctour.data.remote

import com.example.doctour.data.model.TokenRefreshDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.data.remote.dtos.auth.RefreshTokenDto
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class AuthAuthenticator @Inject constructor(
    private val tokenManager: TokenManager
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        val token = runBlocking {
            tokenManager.getToken().first()
        }

        return runBlocking {
            val newToken = getNewToken(token)

            if (!newToken.isSuccessful || newToken.body() == null) {
                tokenManager.deleteToken()
            }

            newToken.body()?.let { tokenRefreshDt ->
                tokenManager.saveToken(tokenRefreshDt.refresh)
                response.request.newBuilder()
                    .addHeader("Authorization","Bearer ${tokenRefreshDt.refresh}")
                    .build()
            }
        }
    }


    suspend fun getNewToken(refreshToken: String?): retrofit2.Response<TokenRefreshDt> {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttp = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://bekbolsun.pythonanywhere.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()

        val service = retrofit.create(DoctourApiService::class.java)
        return service.refreshToken("Bearer $refreshToken")
    }
}