package com.example.doctour.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesHelper @Inject constructor(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("doctour.preferences", Context.MODE_PRIVATE)

    private fun remove(key: String) {
        preferences.edit().remove(key).apply()
    }
}
