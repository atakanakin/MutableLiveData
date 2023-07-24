package com.example.mutablelivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mutablelivedata.R
import com.example.mutablelivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModelFactory = MainActivityViewModelFactory( 0)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]

        viewModel.res.observe(this, Observer {
            binding.textResult.text = it.toString()
        })
        binding.apply {
            buttonTr.setOnClickListener(){
                viewModel.trigger()
            }
            buttonundo.setOnClickListener(){
                viewModel.unDo()
            }
        }
        setContentView(binding.root)

    }


}