package com.example.doctour.data.remote.authentifications

import com.example.doctour.data.model.TokenRefreshBodyDt
import com.example.doctour.data.model.TokenRefreshDt
import com.example.doctour.data.remote.apiservices.AuthenticationApiService
import com.example.doctour.data.remote.authentifications.token.TokenManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
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

            newToken.body()?.let {token ->
                tokenManager.saveToken(token.access)
                response.request
                    .newBuilder()
                    .header("Authorization","Bearer ${token.access}")
                    .build()
            }
        }
    }


    private suspend fun getNewToken(refreshToken: String?): retrofit2.Response<TokenRefreshDt> {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttp = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://15.152.44.148/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()

        val service = retrofit.create(AuthenticationApiService::class.java)
        return service.tokenRefresh(TokenRefreshBodyDt("Bearer $refreshToken"))
    }
}