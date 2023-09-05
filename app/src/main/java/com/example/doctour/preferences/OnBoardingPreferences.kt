package com.example.doctour.preferences

import android.content.Context
import android.content.SharedPreferences
import com.example.doctour.preferences.PreferencesKeys
import javax.inject.Inject

class OnBoardingPreferences @Inject constructor(
    context: Context
) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        PreferencesKeys.PREFERENCE_ON_BOARDING,
        Context.MODE_PRIVATE
    )

    fun setOnBoarding(isShow: Boolean) {
        sharedPreferences.edit().putBoolean(PreferencesKeys.BOARD, isShow).apply()
    }

    fun isShowOnBoarding(): Boolean {
        return sharedPreferences.getBoolean(PreferencesKeys.BOARD, false)
    }
}