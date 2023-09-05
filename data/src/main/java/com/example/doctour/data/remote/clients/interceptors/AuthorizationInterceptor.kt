package com.example.doctour.data.remote.clients.interceptors

import com.example.doctour.data.local.preferences.PreferencesHelper
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor(
    private val preferencesHelper: PreferencesHelper
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain
            .request()
            .newBuilder()
            .addHeader("Authorization", "$preferencesHelper.getAccessToken()")
            .build()
        return chain.proceed(request)
    }
}
