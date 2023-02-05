package com.data.model

import com.google.gson.annotations.SerializedName

data class AirConditionModel(
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
    val county: String,
    @SerializedName("pm2.5")
    val pm2_5: String,
    @SerializedName("pm2.5_avg")
    val pm2_5_avg: String,
    @SerializedName("publishtime")
    val publishTime: String,
    @SerializedName("siteid")
    val siteId: String,
    @SerializedName("sitename")
    val siteName: String,
    val status: String,
)

data class Info(
    val label: String
)