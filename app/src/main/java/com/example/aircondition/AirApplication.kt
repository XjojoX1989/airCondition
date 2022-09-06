package com.example.aircondition

import android.app.Application
import com.assignment.di.viewModelModule
import com.example.data.di.apiModule
import com.example.data.di.mapperModule
import com.example.data.di.repoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AirApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AirApplication)
            modules(listOf(viewModelModule, apiModule, mapperModule, repoModule))
        }
    }
}