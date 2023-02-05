package com.example.aircondition

import com.example.domain.model.AirConditionUIModel
import com.example.domain.repositories.AirRepo
import com.example.domain.usecase.FetchAirConditionDataUseCase
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FetchAirConditionDataUseCaseTest {
    private lateinit var useCase: FetchAirConditionDataUseCase

    @MockK
    private lateinit var repo: AirRepo
    @Before
    fun setup() {
        MockKAnnotations.init(this)
        useCase = FetchAirConditionDataUseCase(repo)
    }

    @Test
    fun `test get air condition data`() = runTest {
        // Arrange
        val limit = "2"
        val apiKey = "api_key"
        val expectedData = flowOf(
                Pair(listOf(AirConditionUIModel("A", "10", "1", "TestA", "Nice")),
                        listOf(AirConditionUIModel("B", "35", "2", "TestB", "Normal")))
        )
        every { repo.getAirCondition(limit, apiKey) } returns expectedData
        //Act
        val actual = useCase(limit, apiKey)

        //Assert
        assertEquals(expectedData, actual)
    }
}
