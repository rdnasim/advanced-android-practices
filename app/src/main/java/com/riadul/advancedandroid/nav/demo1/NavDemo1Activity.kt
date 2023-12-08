package com.riadul.advancedandroid.nav.demo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.databinding.ActivityNavDemo1Binding

class NavDemo1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityNavDemo1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nav_demo1)
    }
}