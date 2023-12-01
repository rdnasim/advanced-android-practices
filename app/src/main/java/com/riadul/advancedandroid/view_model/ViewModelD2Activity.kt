package com.riadul.advancedandroid.view_model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.databinding.ActivityViewModelD2Binding

class ViewModelD2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityViewModelD2Binding
    private lateinit var viewModel: ViewModelD2ActivityViewModel
    private lateinit var viewModelFactory: ViewModelD2ActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model_d2)
        viewModelFactory = ViewModelD2ActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory)[ViewModelD2ActivityViewModel::class.java]

        viewModel.totalData.observe(this) {
            binding.resultTextView.text = it.toString()
        }

        binding.insertButton.setOnClickListener {
            viewModel.setTotal(binding.inputEditText.text.toString().toInt())
        }
    }
}