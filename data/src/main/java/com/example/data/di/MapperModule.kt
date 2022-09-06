package com.example.data.di

import com.example.data.mapper.AirConditionMapper
import org.koin.dsl.module

val mapperModule = module {
    single { AirConditionMapper() }
}