package com.example.androidmvvmwithdagger2retrofitandcoroutines.utils

import android.app.Application
import com.example.androidmvvmwithdagger2retrofitandcoroutines.di.ApplicationComponent
import com.example.androidmvvmwithdagger2retrofitandcoroutines.di.DaggerApplicationComponent

class MyApp: Application() {
    public lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent=DaggerApplicationComponent.builder().build()
    }
}