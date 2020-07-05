package com.nomadworks.spacex.api

import com.nomadworks.spacex.api.model.Launch
import retrofit2.http.GET
import retrofit2.Response

interface SpacexService {
    @GET("launches/latest")
    suspend fun getLatestLaunch(): Launch

    @GET("launches/latest")
    suspend fun getLatestLaunchResponse(): Response<Launch>
}