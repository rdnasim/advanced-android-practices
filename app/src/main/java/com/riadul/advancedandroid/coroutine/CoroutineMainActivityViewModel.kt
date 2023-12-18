package com.riadul.advancedandroid.coroutine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.riadul.advancedandroid.coroutine.model.User
import com.riadul.advancedandroid.coroutine.model.UserRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineMainActivityViewModel : ViewModel() {

    var users : MutableLiveData<List<User>?> = MutableLiveData()
    private var userRepository = UserRepository()

    fun getUserData() {
        viewModelScope.launch{
            var result : List<User>? = null

            withContext(IO){
                result = userRepository.getUsers()
            }

            users.value = result

        }
    }
}