package com.assignment.di

import com.example.aircondition.viewmodel.AirViewModel
import com.example.data.repository.AirRepoImpl
import com.example.domain.usecase.FetchAirConditionDataUseCase
import org.koin.dsl.module

val viewModelModule = module {
    single {
        AirViewModel(useCase = get())
    }
    single {
        FetchAirConditionDataUseCase(AirRepoImpl(service = get(), mapper = get()))
//        FetchAirConditionDataUseCase(repo = get())
    }
}