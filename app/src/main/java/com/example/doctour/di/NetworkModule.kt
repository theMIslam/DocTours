package com.example.doctour.di

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.doctour.data.remote.authentifications.AuthAuthenticator
import com.example.doctour.data.remote.authentifications.AuthInterceptor
import com.example.doctour.data.remote.authentifications.token.TokenManager
import com.example.doctour.data.remote.apiservices.AuthenticationApiService
import com.example.doctour.data.remote.apiservices.DoctourApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    const val BASE_URL_v3 = "https://bekbolsun.pythonanywhere.com/"
    const val BASE_URL_V4 = "http://15.152.44.148/"

    @Singleton
    @Provides
    fun provideTokenManager(@ApplicationContext context: Context): TokenManager =
        TokenManager(context)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
        authAuthenticator: AuthAuthenticator
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .authenticator(authAuthenticator)
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor(
        tokenManager: TokenManager
    ): AuthInterceptor = AuthInterceptor(tokenManager)


    @Singleton
    @Provides
    fun provideAuthAuthenticator(
        tokenManager: TokenManager
    ): AuthAuthenticator = AuthAuthenticator(tokenManager)

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()
        .baseUrl(BASE_URL_V4)
        .addConverterFactory(GsonConverterFactory.create())

    @Singleton
    @Provides
    fun provideDoctorApiService(
        retrofit: Retrofit.Builder,
        okHttpClient: OkHttpClient
    ): DoctourApiService = retrofit
        .client(okHttpClient)
        .build()
        .create(DoctourApiService::class.java)

    @Singleton
    @Provides
    fun provideAuthenticationApiService(retrofit: Retrofit.Builder): AuthenticationApiService =
        retrofit.build().create(AuthenticationApiService::class.java)


    @Singleton
    @Provides
    fun provideTokenErrorListener() = MutableLiveData<String>()

}