package com.nomadworks.spacex.repository

import com.nomadworks.spacex.api.model.Launch
import com.nomadworks.spacex.api.model.error.ApiError
import com.nomadworks.spacex.types.Result

interface SpacexRepository {
    suspend fun fetchLatestLaunch(): Result<Launch, ApiError>
}