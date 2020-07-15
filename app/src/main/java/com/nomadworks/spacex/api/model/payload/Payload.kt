package com.nomadworks.spacex.api.model.payload

import com.google.gson.annotations.SerializedName

data class Payload(
    @SerializedName("name") val name: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("reused") val reused: Boolean? = null,
    @SerializedName("launch") val launchId: String? = null,
    @SerializedName("customers") val customers: List<String>? = null,
    @SerializedName("norad_ids") val noradIds: List<String>? = null,
    @SerializedName("nationalities") val nationalities: List<String>? = null,
    @SerializedName("manufacturers") val manufacturers: List<String>? = null,
    @SerializedName("mass_kg") val massKg: Float? = null,
    @SerializedName("mass_lbs") val massLbs: Float? = null,
    @SerializedName("orbit") val orbit: String? = null,
    @SerializedName("reference_system") val referenceSystem: String? = null,
    @SerializedName("regime") val regime: String? = null,
    @SerializedName("longitude") val longitude: String? = null,
    @SerializedName("semi_major_axis_km") val semiMajorAxisKm : Float? = null,
    @SerializedName("eccentricity") val eccentricity: Float? = null,
    @SerializedName("periapsis_km") val periapsisKm: Float? = null,
    @SerializedName("apoapsis_km") val apoapsisKm: Float? = null,
    @SerializedName("inclination_deg") val inclinationDeg: Float? = null,
    @SerializedName("period_min") val periodMin: Float? = null,
    @SerializedName("lifespan_years") val lifespanYears: Int? = null,
    @SerializedName("epoch") val epoch: String? = null,
    @SerializedName("mean_motion") val meanMotion: Float? = null,
    @SerializedName("raan") val raan: Float? = null,
    @SerializedName("arg_of_pericenter") val argOfPericenter: Float? = null,
    @SerializedName("mean_anomaly") val mean_anomaly: Float? = null,
    @SerializedName("id") val id: String? = null
)