package com.example.androidmvvmwithdagger2retrofitandcoroutines.retrofit

import com.example.androidmvvmwithdagger2retrofitandcoroutines.model.ProductData
import com.example.androidmvvmwithdagger2retrofitandcoroutines.model.ProductDataItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    suspend fun  getProducts():Response<List<ProductDataItem>>
}