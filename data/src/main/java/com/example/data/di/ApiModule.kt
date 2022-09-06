package com.example.data.di

import com.example.data.api.ApiManager
import org.koin.dsl.module

val apiModule = module{
    single { ApiManager.airApi }
}