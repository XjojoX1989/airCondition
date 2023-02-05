package com.example.data.mapper

import com.data.model.AirConditionModel
import com.example.domain.model.AirConditionUIModel

class AirConditionMapper {
    fun toAirConditionUIModelList(data: AirConditionModel): Pair<ArrayList<AirConditionUIModel>, ArrayList<AirConditionUIModel>> {
        val niceList = arrayListOf<AirConditionUIModel>()
        val normalList = arrayListOf<AirConditionUIModel>()
        data.records.forEach {
            if (it.pm2_5.isNotEmpty() && it.pm2_5.toInt() > 30) {
                val airConditionUIModel = AirConditionUIModel(it.county, it.pm2_5, it.siteId, it.siteName, it.status)
                normalList.add(airConditionUIModel)
            }else{
                val airConditionUIModel = AirConditionUIModel(it.county, it.pm2_5, it.siteId, it.siteName, it.status)
                niceList.add(airConditionUIModel)
            }
        }
        return Pair(niceList, normalList)
    }
}