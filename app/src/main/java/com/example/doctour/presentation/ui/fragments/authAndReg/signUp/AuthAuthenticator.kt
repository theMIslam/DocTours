package com.example.doctour.presentation.ui.fragments.authAndReg.signUpimport com.example.doctour.data.model.TokenRefreshDtimport com.example.doctour.data.remote.apiservices.AuthenticatorApiServiceimport com.example.doctour.data.remote.dtos.tokens.RefreshTokenimport com.example.doctour.data.remote.dtos.tokens.Tokensimport com.example.doctour.di.UserPreferencesimport kotlinx.coroutines.runBlockingimport okhttp3.*import okhttp3.logging.HttpLoggingInterceptorimport retrofit2.Retrofitimport retrofit2.converter.gson.GsonConverterFactoryimport javax.inject.Inject//class AuthAuthenticator @Inject constructor(//    private val appPrefs: UserPreferences,//) : Authenticator {//////    override fun authenticate(route: Route?, response: Response): Request? {////        val token = runBlocking {////            appPrefs.refreshToken////        }////        return runBlocking {////            val newToken = getNewToken(token)////////            newToken.body()?.let {////                appPrefs.accessToken = it.access////                response.request.newBuilder().header("Authorization", "Bearer $token").build()////            }////        }////    }////////    private suspend fun getNewToken(refreshToken: String?): retrofit2.Response<TokenRefreshDt> {////        val loggingInterceptor = HttpLoggingInterceptor()////        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY////        val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()////////        val retrofit =////            Retrofit.Builder().baseUrl("http://kitepkana1.pythonanywhere.com/")////                .addConverterFactory(GsonConverterFactory.create())////                .client(okHttpClient).build()////        val service = retrofit.create(AuthenticatorApiService::class.java)////        return service.refreshToken(RefreshToken("Bearer $refreshToken"))////    }//}