package com.example.doctour.di

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class OnBoardingPreferences @Inject constructor(
    context: Context
) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        PreferencesKeys.PREFERENCE_ON_BOARDING,
        Context.MODE_PRIVATE)

    fun setOnBoarding(isShow:Boolean){
        sharedPreferences.edit().putBoolean(PreferencesKeys.BOARD,isShow).apply()
    }

    fun isShowOnBoarding():Boolean{
        return  sharedPreferences.getBoolean(PreferencesKeys.BOARD,false)
    }
}