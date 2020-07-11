package com.nomadworks.spacex.repository

import com.nomadworks.spacex.api.SpacexService
import com.nomadworks.spacex.api.model.Launch
import com.nomadworks.spacex.api.model.error.ApiError
import com.nomadworks.spacex.types.Failure
import com.nomadworks.spacex.types.Result
import com.nomadworks.spacex.types.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SpacexRepositoryImpl(private val spacexService: SpacexService): SpacexRepository {
    override suspend fun fetchLatestLaunchResult(): Result<Launch, ApiError> {
        return try {
            withContext(Dispatchers.IO){
                val response = spacexService.getLatestLaunchResponse()
                if (response.isSuccessful) {
                    val launch = response.body() as Launch
                    launch.Success()
                } else {
                    val error = response.errorBody()?.string() ?: "N/A"
                    ApiError(error).Failure()
                }
            }
        } catch (t: Throwable) {
            ApiError(t.toString()).Failure()
        }
    }

    override suspend fun fetchLatestLaunch(): Launch {
        return withContext(Dispatchers.IO){
            spacexService.getLatestLaunch()
        }
    }
}