package com.example.data.repository

import com.example.data.mapper.AirConditionMapper
import com.example.data.service.AirService
import com.example.domain.model.AirConditionUIModel
import com.example.domain.repositories.AirRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AirRepoImpl(
    private val service: AirService,
    private val mapper: AirConditionMapper
) : AirRepo {
    override fun getAirCondition(
        limit: String,
        apiKey: String,
    ): Flow<Pair<List<AirConditionUIModel>, List<AirConditionUIModel>>> {
        return flow {
            try {
                val result = service.getAirConditionList(limit, apiKey)
                emit(mapper.toAirConditionUIModelList(result))
            }catch (e:Exception){
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }
}