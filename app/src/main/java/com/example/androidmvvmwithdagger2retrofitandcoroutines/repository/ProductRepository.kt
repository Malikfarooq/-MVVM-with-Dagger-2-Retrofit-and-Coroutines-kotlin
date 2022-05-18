package com.example.androidmvvmwithdagger2retrofitandcoroutines.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidmvvmwithdagger2retrofitandcoroutines.model.ProductData
import com.example.androidmvvmwithdagger2retrofitandcoroutines.model.ProductDataItem
import com.example.androidmvvmwithdagger2retrofitandcoroutines.retrofit.ApiInterface
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiInterface: ApiInterface
) {
    private val product = MutableLiveData<List<ProductDataItem>>()


    fun productData(): LiveData<List<ProductDataItem>> {
        return product
    }

    suspend fun getProduct() {
        val result = apiInterface.getProducts();

        if (result.isSuccessful && result.body() != null) {
            product.postValue(result.body())
        }
    }
}