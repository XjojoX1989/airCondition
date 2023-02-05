package com.example.domain.usecase

import com.example.domain.model.AirConditionUIModel
import com.example.domain.repositories.AirRepo
import kotlinx.coroutines.flow.Flow

class FetchAirConditionDataUseCase(private val repo: AirRepo) {
    operator fun invoke(
        limit: String,
        apiKey: String,
    ): Flow<Pair<List<AirConditionUIModel>, List<AirConditionUIModel>>> {
        return repo.getAirCondition(limit, apiKey)
    }
}