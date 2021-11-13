package com.koshake1.geolocationapp

import android.app.Application
import com.koshake1.geolocationapp.di.application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                application
            )
        }
    }
}