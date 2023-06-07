package com.example.doctour.data.remote.client.authenticator

import com.example.doctour.data.local.preferences.PreferencesHelper
import com.example.doctour.data.remote.apiservices.AuthenticatorApiService
import com.example.doctour.data.remote.dtos.tokens.RefreshToken
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val service: AuthenticatorApiService,
    private val preferencesHelper: PreferencesHelper
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        synchronized(this) {
            val refreshToken = service.refreshToken(RefreshToken("<refresh_token>")).execute()

            return when {
                refreshToken.isSuccessful -> {
                    // TODO: Save access & refresh tokens to preferences
                    "$preferencesHelper."

                    response
                        .request
                        .newBuilder()
                        .header("Authorization", "Bearer $preferencesHelper.<new_access_token>")
                        .build()
                }
                else -> {
                    null
                }
            }
        }
    }
}