package com.riadul.advancedandroid.view_model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.databinding.ActivityViewModelD1Binding

class ViewModelD1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityViewModelD1Binding
    private lateinit var viewModel: ViewModelD1ActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model_d1)

        viewModel = ViewModelProvider(this)[ViewModelD1ActivityViewModel::class.java]

        viewModel.count.observe(this) {
            binding.countText.text = it.toString()
        }

        binding.button.setOnClickListener {
            viewModel.updateCount()
        }
    }
}