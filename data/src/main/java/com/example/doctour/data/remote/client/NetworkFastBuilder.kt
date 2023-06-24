package com.example.doctour.data.remote.client

import com.example.doctour.data.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        // по факту тут должно быть BASE_URL
    .baseUrl(BuildConfig.BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(
        MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build())
    )
    .build()

internal fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient()
    .newBuilder()
    .addInterceptor(provideLoggingInterceptor())
    .callTimeout(30, TimeUnit.SECONDS)
    .connectTimeout(30, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(30, TimeUnit.SECONDS)

private fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
)