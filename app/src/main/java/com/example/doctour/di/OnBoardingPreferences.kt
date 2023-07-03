package com.example.doctour.di

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class OnBoardingPreferences @Inject constructor(
    context: Context
) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "preference_onBoarding",
        Context.MODE_PRIVATE)

    fun setOnBoarding(isShow:Boolean){
        sharedPreferences.edit().putBoolean("board",isShow).apply()
    }

    fun isShowOnBoarding():Boolean{
        return  sharedPreferences.getBoolean("board",false)
    }
}