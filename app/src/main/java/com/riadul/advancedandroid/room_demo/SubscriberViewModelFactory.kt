package com.riadul.advancedandroid.room_demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.riadul.advancedandroid.room_demo.db.SubscriberRepository

class SubscriberViewModelFactory(
    private val repository: SubscriberRepository
)  : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubscriberViewModel::class.java)) {
            return SubscriberViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }
}