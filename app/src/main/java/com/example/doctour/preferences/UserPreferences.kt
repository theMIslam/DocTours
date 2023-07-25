package com.example.doctour.preferences

import android.content.Context
import android.content.SharedPreferences
import com.example.doctour.di.clear
import com.example.doctour.di.put
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject


class UserPreferences @Inject constructor(
    context: Context
) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "preference",
        Context.MODE_PRIVATE)
   private val editor :SharedPreferences.Editor = sharedPreferences.edit()


    fun setOTPKode(isShow:Boolean){
        sharedPreferences.edit().putBoolean("codeOtp",isShow).apply()
    }

    fun isOtpCodeRight():Boolean{
        return  sharedPreferences.getBoolean("codeOtp",false)
    }

    fun setLogin (isLogin:Boolean){
        editor.putBoolean("Login",isLogin).commit()
    }
    fun isLogin():Boolean{
        return sharedPreferences.getBoolean("Login",false)
    }
    fun removeData(){
        editor.clear()
        editor.commit()
    }

    var isAuthenticated: Boolean
        get() = sharedPreferences.getBoolean(PreferencesKeys.IS_AUTHENTICATED, false)
        set(value) = sharedPreferences.put(PreferencesKeys.IS_AUTHENTICATED, value)

    var accessToken: String?
        get() = sharedPreferences.getString(PreferencesKeys.ACCESS_TOKEN, "")
        set(value) = sharedPreferences.put(PreferencesKeys.ACCESS_TOKEN, value.toString())

    var refreshToken: String?
        get() = sharedPreferences.getString(PreferencesKeys.REFRESH_TOKEN, "")
        set(value) = sharedPreferences.put(PreferencesKeys.REFRESH_TOKEN, value.toString())

    var userID: String?
        get() = sharedPreferences.getString(PreferencesKeys.USER_ID, "")
        set(value) = sharedPreferences.put(PreferencesKeys.USER_ID, value.toString())

    var username: String?
        get() = sharedPreferences.getString(PreferencesKeys.USERNAME, "")
        set(value) = sharedPreferences.put(PreferencesKeys.USERNAME, value.toString())

    var password: String?
        get() = sharedPreferences.getString(PreferencesKeys.PASSWORD, "")
        set(value) = sharedPreferences.put(PreferencesKeys.PASSWORD, value.toString())

    var userNumber: String?
        get() = sharedPreferences.getString(PreferencesKeys.USER_NUMBER, "")
        set(value) = sharedPreferences.put(PreferencesKeys.USER_NUMBER, value.toString())


    fun clearPreferences() = sharedPreferences.clear()

    private val _authenticationState = MutableSharedFlow<Boolean>()
    val authenticationState: SharedFlow<Boolean> = _authenticationState
}
