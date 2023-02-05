package com.example.aircondition

import com.example.aircondition.viewmodel.AirViewModel
import com.example.domain.model.AirConditionUIModel
import com.example.domain.usecase.FetchAirConditionDataUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class AirViewModelTest {
    private val useCase = Mockito.mock(FetchAirConditionDataUseCase::class.java)
    private val airViewModel = AirViewModel(useCase)

    @Test
    fun `test queryAirConditionList`() = runBlocking {
        val expected =
            Pair(listOf(AirConditionUIModel("A", "10", "1", "TestA", "Nice")),
                listOf(AirConditionUIModel("B", "35", "2", "TestB", "Normal")))
        Mockito.`when`(useCase.invoke("1000", "key")).thenReturn(MutableStateFlow(expected))

        val actual = airViewModel.queryAirConditionList().first()

        assertEquals(expected, actual)
    }

    @Test
    fun `test updateSearchText`() = runBlocking {
        airViewModel.updateSearchText("test")

        assertEquals("test", airViewModel.searchText.first())
    }

    @Test
    fun `test searchStateFlow`() = runBlocking {
        airViewModel.updateSearchText("test")

        val expected = "找不到『test』相關的空污資訊"
        val actual = airViewModel.searchStateFlow.first()

        assertEquals(expected, actual)
    }

}

