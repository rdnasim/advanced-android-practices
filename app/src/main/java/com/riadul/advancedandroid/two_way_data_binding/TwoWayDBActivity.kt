package com.riadul.advancedandroid.two_way_data_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.databinding.ActivityTwoWayDbactivityBinding

class TwoWayDBActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTwoWayDbactivityBinding
    private lateinit var viewModel: TwoWayDBActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_dbactivity)
        viewModel = ViewModelProvider(this)[TwoWayDBActivityViewModel::class.java]

        binding.twoWayDBViewModel = viewModel
        binding.lifecycleOwner = this
    }
}