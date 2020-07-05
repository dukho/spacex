package com.nomadworks.spacex.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Named

@InstallIn(ApplicationComponent::class)
@Module
class ApplicationModule {
    @Provides
    @Named("CONFIG")
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("configuration", Context.MODE_PRIVATE)
    }
}