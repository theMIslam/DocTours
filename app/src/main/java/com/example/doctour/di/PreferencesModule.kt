package com.example.doctour.di

import android.content.Context
import android.content.SharedPreferences
import com.example.doctour.data.local.preferences.PreferencesHelper
import com.example.doctour.di.PreferencesKeys.DOCTOUR_SHARED_PREFERENCES
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Singleton
    @Provides
    fun providePreferencesHelper(
        @ApplicationContext context: Context
    ) = PreferencesHelper(context)

    @Singleton
    @Provides
    fun provideUserPreferences(
        @ApplicationContext context: Context
    ) = UserPreferences(context)

    @Singleton
    @Provides
    fun provideProfilePreferences(
        @ApplicationContext context: Context
    ) = ProfilePreferences(context)

    @Singleton
    @Provides
    fun generateSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(
            DOCTOUR_SHARED_PREFERENCES,
            Context.MODE_PRIVATE
        )
}