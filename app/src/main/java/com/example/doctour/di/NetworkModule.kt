package com.example.doctour.di

import androidx.lifecycle.MutableLiveData
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.data.remote.apiservices.UserRegisterApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    const val BASE_URL_V2 = "https://bekbolsun.pythonanywhere.com/"
    const val BASE_URL_v3 = "https://bekbolsun.pythonanywhere.com/"
    @Singleton
    @Provides
    fun provideTokenErrorListener() = MutableLiveData<String>()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
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
        return retrofit.create(DoctourApiService::class.java)
    }
    @Singleton
    @Provides
    fun provideUserRegisterApiService(retrofit: Retrofit) :UserRegisterApiService{
       return retrofit.create(UserRegisterApiService::class.java)
    }


}