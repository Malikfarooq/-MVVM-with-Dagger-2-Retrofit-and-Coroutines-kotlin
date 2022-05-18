package com.example.androidmvvmwithdagger2retrofitandcoroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidmvvmwithdagger2retrofitandcoroutines.model.ProductData
import com.example.androidmvvmwithdagger2retrofitandcoroutines.model.ProductDataItem
import com.example.androidmvvmwithdagger2retrofitandcoroutines.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(val repository: ProductRepository):ViewModel() {

    val productLiveData : LiveData<List<ProductDataItem>> get()
    =repository.productData()

    init {
        viewModelScope.launch {
            repository.getProduct()
        }
    }
}