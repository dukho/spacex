package com.nomadworks.spacex.di

import com.nomadworks.spacex.api.SpacexService
import com.nomadworks.spacex.repository.SpacexRepository
import com.nomadworks.spacex.repository.SpacexRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class RepositoryModule {
    @Provides
    fun provideRepository(spacexService: SpacexService): SpacexRepository {
        return SpacexRepositoryImpl(spacexService)
    }
}