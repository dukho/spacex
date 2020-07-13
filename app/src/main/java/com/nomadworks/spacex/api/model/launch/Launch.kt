package com.nomadworks.spacex.api.model.launch

import com.google.gson.annotations.SerializedName

data class Launch(
    @SerializedName("static_fire_date_utc")  val staticFireDateUtc: String? = null,
    @SerializedName("static_fire_date_unix") val staticFireDateUnix: Long? = null,
    @SerializedName("rocket") val rocketId: String? = null,
    @SerializedName("details") val details: String? = null,
    @SerializedName("crew") val crews: List<String>? = null,
    @SerializedName("ships") val ships: List<String>? = null,
    @SerializedName("capsules") val capsules: List<String>? = null,
    @SerializedName("payloads") val payloads: List<String>? = null,
    @SerializedName("launchpad") val launchpad: String? = null,
    @SerializedName("flight_number") val flightNumber: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("date_utc") val dateUtc: String? = null,
    @SerializedName("date_unix") val dateUnix: Long? = null,
    @SerializedName("cores") val cores: List<Core>? = null
)