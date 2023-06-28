package com.example.doctour.data.remote.client

import com.example.doctour.data.remote.apiservices.AuthenticatorApiService
import com.example.doctour.data.remote.apiservices.DoctourApiService
//import com.example.doctour.data.remote.client.authenticator.TokenAuthenticator
import com.example.doctour.data.remote.client.interceptors.AuthorizationInterceptor
import javax.inject.Inject

//class NetworkClient @Inject constructor(
//    authenticator: TokenAuthenticator,
//    authorizationInterceptor: AuthorizationInterceptor
//) {
//    private val provideRetrofit = provideRetrofit(
//        provideOkHttpClientBuilder().apply {
//            authenticator(authenticator)
//            addInterceptor(authorizationInterceptor)
//        }.build()
//    )
//
//    fun provideFooApiService(): DoctourApiService = provideRetrofit.create(
//        DoctourApiService::class.java
//    )
//
//    class AuthenticatorClient @Inject constructor() {
//
//        private val provideRetrofit = provideRetrofit(provideOkHttpClientBuilder().build())
//
//        fun provideAuthenticatorApiService(): AuthenticatorApiService = provideRetrofit.create(
//            AuthenticatorApiService::class.java
//        )
//    }
//}