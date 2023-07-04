package com.example.doctour.di

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class ProfilePreferences @Inject constructor(
    context: Context
)  {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "preference_profile",
        Context.MODE_PRIVATE)

    fun getName():String{
        return sharedPreferences.getString("name","").toString()
    }
    fun saveName(name:String){
        sharedPreferences.edit().putString("name",name).apply()
    }

    fun getPhone():String{
        return sharedPreferences.getString("phone","").toString()
    }
    fun savePhone(name:String){
        sharedPreferences.edit().putString("phone",name).apply()
    }

    fun getBirthday():String{
        return sharedPreferences.getString("birthday","").toString()
    }
    fun saveBirthday(name:String){
        sharedPreferences.edit().putString("birthday",name).apply()
    }

    fun getGender():String{
        return sharedPreferences.getString("gender","").toString()
    }
    fun saveGender(name:String){
        sharedPreferences.edit().putString("gender",name).apply()
    }



}