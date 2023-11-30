package com.riadul.advancedandroid.view_model

import androidx.lifecycle.ViewModel

class ViewModelD1ActivityViewModel : ViewModel() {
    private var count = 0

    fun getCurrentCount(): Int {
        return count
    }

    fun getUpdatedCount(): Int {
        return ++count
    }
}