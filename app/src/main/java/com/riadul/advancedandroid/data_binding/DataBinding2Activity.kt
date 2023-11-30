package com.riadul.advancedandroid.data_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.databinding.ActivityDataBinding2Binding

class DataBinding2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding2)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding2)

        binding.controlButton.setOnClickListener {
            startOrStopProgressBar()
        }
    }

    private fun startOrStopProgressBar() {
        binding.apply {
            if (progressBar.visibility == View.GONE) {
                progressBar.visibility = View.VISIBLE
                controlButton.text = "Stop"
            } else {
                progressBar.visibility = View.GONE
                controlButton.text = "Start"
            }
        }
    }
}