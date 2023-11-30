package com.riadul.advancedandroid.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelD1ActivityViewModel : ViewModel() {

    var count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun updateCount() {
        count.value = (count.value)?.plus(1)
    }
}