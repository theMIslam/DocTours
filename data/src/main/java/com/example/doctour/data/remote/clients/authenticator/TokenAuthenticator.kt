package com.example.doctour.data.remote.clients.authenticator

//class TokenAuthenticator @Inject constructor(
//    private val service: AuthenticatorApiService,
//    private val preferencesHelper: PreferencesHelper
//) : Authenticator {
//
//    override fun authenticate(route: Route?, response: Response): Request? {
//        synchronized(this) {
//            val refreshToken = service.refreshToken(RefreshToken("<refresh_token>")).execute()
//
//            return when {
//                refreshToken.isSuccessful -> {
//                    /**
//                     * Save access & refresh tokens to preferences
//                     */
//                    "$preferencesHelper."
//
//                    response
//                        .request
//                        .newBuilder()
//                        .header("Authorization", "Bearer $preferencesHelper.<new_access_token>")
//                        .build()
//                }
//
//                else -> {
//                    null
//                }
//            }
//        }
//    }
//}