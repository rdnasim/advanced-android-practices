package com.riadul.advancedandroid.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelD2ActivityViewModelFactory(
    private val startingTotal: Int
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelD2ActivityViewModel::class.java)) {
            return ViewModelD2ActivityViewModel(startingTotal) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}