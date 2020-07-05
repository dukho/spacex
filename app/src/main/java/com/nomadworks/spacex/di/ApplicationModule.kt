package com.nomadworks.spacex.di

import android.content.Context
import android.content.SharedPreferences
import com.nomadworks.spacex.resource.ResourceQuery
import com.nomadworks.spacex.resource.ResourceQueryImpl
import dagger.Binds
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