package com.example.doctour.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class ProfilePreferences @Inject constructor(
    context: Context
) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        PreferencesKeys.PREFERENCE_PROFILE,
        Context.MODE_PRIVATE
    )

    fun getId(): String {
        return sharedPreferences.getString(PreferencesKeys.ID_PROFILE, "").toString()
    }

    fun saveID(id: String) {
        sharedPreferences.edit().putString(PreferencesKeys.ID_PROFILE, id).apply()
    }

    fun getName(): String {
        return sharedPreferences.getString(PreferencesKeys.NAME, "").toString()
    }

    fun saveName(name: String) {
        sharedPreferences.edit().putString(PreferencesKeys.NAME, name).apply()
    }

    fun getPhone(): String {
        return sharedPreferences.getString(PreferencesKeys.PHONE, "").toString()
    }

    fun savePhone(name: String) {
        sharedPreferences.edit().putString(PreferencesKeys.PHONE, name).apply()
    }

    fun getBirthday(): String {
        return sharedPreferences.getString(PreferencesKeys.BIRTHDAY, "").toString()
    }

    fun saveBirthday(name: String) {
        sharedPreferences.edit().putString(PreferencesKeys.BIRTHDAY, name).apply()
    }

    fun getGender(): String {
        return sharedPreferences.getString(PreferencesKeys.GENDER, "").toString()
    }

    fun saveGender(name: String) {
        sharedPreferences.edit().putString(PreferencesKeys.GENDER, name).apply()
    }


}