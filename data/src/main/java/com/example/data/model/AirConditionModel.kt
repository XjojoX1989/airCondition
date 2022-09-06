package com.data.model

import com.google.gson.annotations.SerializedName

data class AirConditionModel(
    val __extras: Extras,
    val links: Links,
    val fields: List<Field>,
    val include_total: Boolean,
    val limit: String,
    val offset: String,
    val records: List<Record>,
    val resource_format: String,
    val resource_id: String,
    val total: String
)

data class Extras(
    @SerializedName("api_key")
    val apikey: String
)

data class Links(
    val next: String,
    val start: String
)

data class Field(
    val id: String,
    val info: Info,
    val type: String
)

data class Record(
    val aqi: String,
    val co: String,
    val co_8hr: String,
    val county: String,
    val latitude: String,
    val longitude: String,
    val no: String,
    val no2: String,
    val nox: String,
    val o3: String,
    val o3_8hr: String,
    val pm10: String,
    val pm10_avg: String,
    @SerializedName("pm2.5")
    val pm2_5: String,
    @SerializedName("pm2.5_avg")
    val pm2_5_avg: String,
    val pollutant: String,
    @SerializedName("publishtime")
    val publishTime: String,
    @SerializedName("siteid")
    val siteId: String,
    @SerializedName("sitename")
    val siteName: String,
    val so2: String,
    val so2_avg: String,
    val status: String,
    @SerializedName("wind_direc")
    val windDirec: String,
    @SerializedName("wind_speed")
    val windSpeed: String
)

data class Info(
    val label: String
)