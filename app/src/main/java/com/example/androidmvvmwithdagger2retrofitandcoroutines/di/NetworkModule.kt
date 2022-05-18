package com.example.androidmvvmwithdagger2retrofitandcoroutines.di

import com.example.androidmvvmwithdagger2retrofitandcoroutines.retrofit.ApiInterface
import com.example.androidmvvmwithdagger2retrofitandcoroutines.utils.Constant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {


    @Singleton
    @Provides
    fun  provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit):ApiInterface{

        return  retrofit.create(ApiInterface::class.java)
    }
}