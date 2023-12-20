package com.riadul.advancedandroid.room_demo

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.riadul.advancedandroid.room_demo.db.Subscriber
import com.riadul.advancedandroid.room_demo.db.SubscriberRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.regex.Pattern

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val subscribers = repository.subscribers
    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete: Subscriber

    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()

    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message: MutableLiveData<Event<String>>
        get() = statusMessage

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate() {

        if (inputName.value == null || inputName.value!!.isEmpty()) {
            statusMessage.value = Event("Please enter subscriber's name")
        } else if (inputEmail.value == null || inputEmail.value!!.isEmpty()) {
            statusMessage.value = Event("Please enter subscriber's email")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()) {
            statusMessage.value = Event("Please enter a correct email address")
        } else {
            if (isUpdateOrDelete) {
                subscriberToUpdateOrDelete.name = inputName.value!!
                subscriberToUpdateOrDelete.email = inputEmail.value!!
                update(subscriberToUpdateOrDelete)
            } else {
                val name = inputName.value!!
                val email = inputEmail.value!!
                insert(Subscriber(0, name, email))

                inputName.value = ""
                inputEmail.value = ""
            }
        }
    }


    fun clearAllOrDelete() {
        if (isUpdateOrDelete) {
            delete(subscriberToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    private fun insert(subscriber: Subscriber) {
        viewModelScope.launch(IO) {
           val newRowId = repository.insert(subscriber)

            withContext(Main) {
                if (newRowId > -1) {
                    statusMessage.value = Event("Subscriber Inserted Successfully $newRowId")
                } else {
                    statusMessage.value = Event("Error Occurred")
                }
            }
        }
    }
    private fun update(subscriber: Subscriber) {
        viewModelScope.launch(IO) {
            val numberOfRows = repository.update(subscriber)
            withContext(Main) {
                if (numberOfRows > 0) {
                    inputName.value = ""
                    inputEmail.value = ""
                    isUpdateOrDelete = false

                    saveOrUpdateButtonText.value = "Save"
                    clearAllOrDeleteButtonText.value = "Clear All"

                    statusMessage.value = Event("$numberOfRows Subscriber Updated")
                } else {
                    statusMessage.value = Event("Error Occurred")
                }
            }
        }
    }
    private fun delete(subscriber: Subscriber) {
        viewModelScope.launch(IO) {
            val numberOfRowDeleted = repository.delete(subscriber)
            withContext(Main) {
                if (numberOfRowDeleted > 0) {
                    inputName.value = ""
                    inputEmail.value = ""

                    isUpdateOrDelete = false

                    saveOrUpdateButtonText.value = "Save"
                    clearAllOrDeleteButtonText.value = "Clear All"

                    statusMessage.value = Event("$numberOfRowDeleted Subscriber Deleted")
                } else {
                    statusMessage.value = Event("Error Occurred")
                }

            }
        }
    }
    private fun clearAll() {
        viewModelScope.launch(IO) {
            val  numberOfRowsDeleted = repository.deleteAll()

            withContext(Main) {
                if (numberOfRowsDeleted > 0) {
                    statusMessage.value = Event("$numberOfRowsDeleted Subscribers Deleted")
                } else {
                    statusMessage.value = Event("Error Occurred")
                }
            }
        }
    }

    fun initUpdateAndDelete(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email

        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber

        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"

    }
}