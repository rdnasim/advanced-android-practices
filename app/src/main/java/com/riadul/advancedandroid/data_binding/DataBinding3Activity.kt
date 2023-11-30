package com.riadul.advancedandroid.data_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.data_binding.model.Student
import com.riadul.advancedandroid.databinding.ActivityDataBinding3Binding

class DataBinding3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding3)

        binding.student = getStudent()
    }

    private fun getStudent(): Student {
        return Student(1, "Riadul", "qJX6H@example.com")
    }
}