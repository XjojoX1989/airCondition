package com.example.data.service

import com.data.model.AirConditionModel
import retrofit2.http.GET
import retrofit2.http.Query

interface AirService {

    @GET(GET_AIR_CONDITION)
    suspend fun getAirConditionList(
        @Query("limit") limit: String,
        @Query("api_key") apiKey: String,
        @Query("sort") sort: String = "ImportDate",
        @Query("format") format: String = "json"
    ): AirConditionModel

    companion object {
        private const val GET_AIR_CONDITION = "api/v2/aqx_p_432?"
    }
}