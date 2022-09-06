package com.example.data.service

import com.data.model.AirConditionModel
import retrofit2.http.GET
import retrofit2.http.Query

interface AirService {

    @GET(GET_AIR_CONDITION)
    suspend fun getAirConditionList(
        @Query("limit") limit: String,
        @Query("api_key") apiKey: String,
        @Query("sort") sort: String = "ImportDate Desc",
        @Query("format") format: String = "json"
    ): AirConditionModel

    @GET(GET_AIR_CONDITION_2)
    suspend fun getAirConditionList2(): AirConditionModel

    companion object {
        private const val GET_AIR_CONDITION = "api/v2/aqx_p_432"
        private const val GET_AIR_CONDITION_2 =
            "api/v2/aqx_p_432?limit=1000&api_key=cebebe84-e17d-4022-a28f-81097fda5896&sort=ImportDate&format=json"
    }
}