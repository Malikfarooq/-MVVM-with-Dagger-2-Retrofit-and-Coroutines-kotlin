package com.example.androidmvvmwithdagger2retrofitandcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmvvmwithdagger2retrofitandcoroutines.utils.MyApp
import com.example.androidmvvmwithdagger2retrofitandcoroutines.viewmodel.MainViewModel
import com.example.androidmvvmwithdagger2retrofitandcoroutines.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var textView: TextView;
    //Field injection
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView=findViewById(R.id.tv_products)

//component automatically will create the object
        (application as MyApp).applicationComponent.inject(this)
   mainViewModel = ViewModelProvider(this,mainViewModelFactory)[MainViewModel::class.java]


        mainViewModel.productLiveData.observe(this, Observer {
           textView.text= it.joinToString { x -> "${ x.title }" }

        })
    }
}