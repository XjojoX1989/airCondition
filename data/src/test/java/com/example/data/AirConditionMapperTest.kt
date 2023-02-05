package com.example.data

import com.data.model.AirConditionModel
import com.data.model.Record
import com.example.data.mapper.AirConditionMapper
import com.example.domain.model.AirConditionUIModel
import org.junit.Assert.assertEquals
import org.junit.Test

class AirConditionMapperTest {

    private val mapper = AirConditionMapper()

    @Test
    fun `test toAirConditionUIModelList`() {
        val records = listOf(
            Record(county = "Taipei", pm2_5 = "10", siteId = "1000", siteName = "Taipei Site", pm2_5_avg = "", publishTime = "", status = ""),
            Record(county = "New Taipei", pm2_5 = "40", siteId = "1001", siteName = "New Taipei Site", pm2_5_avg = "", publishTime = "", status = ""),
            Record(county = "Taichung", pm2_5 = "15", siteId = "1002", siteName = "Taichung Site", pm2_5_avg = "", publishTime = "", status = "")
        )
        val data = AirConditionModel(false,"","", records,"","","")

        val result = mapper.toAirConditionUIModelList(data)

        assertEquals(2, result.first.size)
        assertEquals("Taipei", result.first[0].county)
        assertEquals("Taichung", result.first[1].county)
        assertEquals(1, result.second.size)
        assertEquals("New Taipei", result.second[0].county)
    }
}
