package com.example.doctour.di

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.doctour.data.remote.AuthAuthenticator
import com.example.doctour.data.remote.AuthInterceptor
import com.example.doctour.data.remote.TokenManager
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.data.remote.apiservices.UserRegisterApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    const val BASE_URL_v3 = "https://bekbolsun.pythonanywhere.com/"

    @Singleton
    @Provides
    fun provideTokenManager(@ApplicationContext context: Context):TokenManager{
        return TokenManager(context)
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor(
        tokenManager: TokenManager
    ):AuthInterceptor{
        return AuthInterceptor(tokenManager)
    }

    @Singleton
    @Provides
    fun provideAuthAuthenticator(
        tokenManager: TokenManager
    ):AuthAuthenticator{
        return AuthAuthenticator(tokenManager)
    }


    @Singleton
    @Provides
    fun provideTokenErrorListener() = MutableLiveData<String>()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptor,
        authAuthenticator: AuthAuthenticator
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .authenticator(authAuthenticator)
            .build()

    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_v3)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideDoctorApiService(retrofit: Retrofit): DoctourApiService {
        //return retrofit.create(DoctourApiService::class.java)

        return retrofit.create(DoctourApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideUserRegisterApiService(retrofit: Retrofit): UserRegisterApiService {
        return retrofit.create(UserRegisterApiService::class.java)
    }


}