package com.example.androidmvvmwithdagger2retrofitandcoroutines.di

import com.example.androidmvvmwithdagger2retrofitandcoroutines.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}