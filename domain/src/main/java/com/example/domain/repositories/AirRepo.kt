package com.example.domain.repositories

import com.example.domain.model.AirConditionUIModel
import kotlinx.coroutines.flow.Flow

interface AirRepo {
    fun getAirCondition(
        limit: String,
        apiKey: String,
    ): Flow<Pair<List<AirConditionUIModel>, List<AirConditionUIModel>>>
}