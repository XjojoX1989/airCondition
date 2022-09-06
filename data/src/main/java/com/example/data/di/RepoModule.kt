package com.example.data.di

import com.example.data.repository.AirRepoImpl
import org.koin.dsl.module

val repoModule = module {
    single { AirRepoImpl(service = get(), mapper = get()) }
}