package com.nomadworks.spacex.api.model

import com.google.gson.annotations.SerializedName

data class Core(
    @SerializedName("core") val coreId: String? = null,
    @SerializedName("flight") val flight: Int? = null,
    @SerializedName("gridfins") val gridFins: Boolean? = null,
    @SerializedName("legs") val legs: Boolean? = null,
    @SerializedName("reused") val reused: Boolean? = null,
    @SerializedName("landing_attempt") val landingAttempt: Boolean? = null,
    @SerializedName("landing_success") val landingSuccess: Boolean? = null,
    @SerializedName("landing_type") val landingType: String? = null,
    @SerializedName("landpad") val landpadId: String? = null
)