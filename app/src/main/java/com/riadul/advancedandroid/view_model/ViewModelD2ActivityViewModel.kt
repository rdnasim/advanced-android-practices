package com.riadul.advancedandroid.view_model

import androidx.lifecycle.ViewModel

class ViewModelD2ActivityViewModel(
    startingTotal: Int
) : ViewModel() {
    private var total = 0

    init {
        total = startingTotal
    }

    fun getTotal(): Int {
        return total
    }

    fun setTotal(input: Int) {
        total += input
    }
}