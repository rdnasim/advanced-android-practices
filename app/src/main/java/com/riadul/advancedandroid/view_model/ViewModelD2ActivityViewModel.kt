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
    val inputText = MutableLiveData<String>()

    init {
        total.value = startingTotal
    }

    fun setTotal() {
        val intInput: Int = inputText.value?.toInt() ?: 0
        total.value = (total.value)?.plus(intInput)
    }
}