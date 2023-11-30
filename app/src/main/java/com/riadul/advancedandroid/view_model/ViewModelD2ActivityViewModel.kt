package com.riadul.advancedandroid.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelD2ActivityViewModel(
    startingTotal: Int
) : ViewModel() {

    private var total = MutableLiveData<Int>()

    val totalData: LiveData<Int>
        get() = total

    init {
        total.value = startingTotal
    }

    fun setTotal(input: Int) {
        total.value = (total.value)?.plus(input)
    }
}