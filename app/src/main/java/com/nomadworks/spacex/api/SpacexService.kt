package com.nomadworks.spacex.api

import com.nomadworks.spacex.api.model.launch.Launch
import com.nomadworks.spacex.api.model.payload.Payload
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Path

interface SpacexService {
    @GET("launches/latest")
    suspend fun getLatestLaunch(): Launch

    @GET("launches/latest")
    suspend fun getLatestLaunchResponse(): Response<Launch>

    @GET("payloads")
    suspend fun getAllPayloads(): List<Payload>

    @GET("payloads/{id}")
    suspend fun getPayloadById(@Path("id") payloadId: String): Payload
}