package com.riadul.advancedandroid.two_way_data_binding

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoWayDBActivityViewModel: ViewModel(), Observable {

    @Bindable
    val userName = MutableLiveData<String>()
    init {
        userName.value = "Riadul"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        //TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        //TODO("Not yet implemented")
    }
}