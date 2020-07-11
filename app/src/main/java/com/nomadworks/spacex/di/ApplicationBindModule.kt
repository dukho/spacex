package com.nomadworks.spacex.di

import com.nomadworks.spacex.resource.ResourceQuery
import com.nomadworks.spacex.resource.ResourceQueryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class ApplicationBindModule {
    @Binds
    abstract fun bindResourceQuery(resourceQueryImpl: ResourceQueryImpl): ResourceQuery
}