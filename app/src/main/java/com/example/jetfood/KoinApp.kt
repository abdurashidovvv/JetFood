package com.example.jetfood

import android.app.Application
import com.example.jetfood.koin.myModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(applicationContext)
            modules(myModule)
        }
    }
}