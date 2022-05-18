package com.example.androidmvvmwithdagger2retrofitandcoroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.androidmvvmwithdagger2retrofitandcoroutines.model.ProductData
import com.example.androidmvvmwithdagger2retrofitandcoroutines.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModelFactory @Inject constructor
    (private val repository: ProductRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
         return  MainViewModel(repository) as T;
    }


}